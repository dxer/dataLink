package io.dxer.datalink.spark.sql.execution

import java.util.Properties
import java.util.regex.Pattern

import com.google.common.base.Strings
import io.dxer.datalink.grok.Grok
import io.dxer.datalink.spark.util.SparkUtils
import io.dxer.datalink.spark.{Constants, DataLinkSparkSession}
import io.dxer.datalink.sql.execution.LoadTableCommand
import io.dxer.datalink.sql.parser.LoadTable
import io.dxer.datalink.sql.{ConnectionManager, DataLinkSession}
import io.dxer.datalink.util.{PropertiesUtils, Utils}
import org.apache.spark.SparkException
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, DataFrameReader, Row, SparkSession}

import scala.collection.JavaConversions._

class SparkLoadTableCommand(loadTable: LoadTable) extends LoadTableCommand(loadTable) {

  protected override def loadAsTable(dataLinkSession: DataLinkSession, loadTable: LoadTable): Unit = {
    val dataLinkSparkSession = dataLinkSession.asInstanceOf[DataLinkSparkSession]
    val sparkSession = dataLinkSparkSession.sparkSession

    val tableName = loadTable.tableIdentifier.getTableName()

    require(!Strings.isNullOrEmpty(tableName), "LoadAsTable tableName is null")

    // check table exists
    if (dataLinkSparkSession.checkTableExists(sparkSession, tableName)) {
      throw new SparkException(s"${tableName} is exists")
    }

    val connectionManager = dataLinkSession.connectionManager

    val reader = sparkSession.sqlContext.read

    val inputFormat = getInputFormat(PropertiesUtils.getString(loadTable.properties, "inputFormatClass"))

    val format = loadTable.format.toLowerCase

    val df: DataFrame = format match {
      case Constants.HIVE =>
        sparkSession.table(loadTable.path)

      case Constants.JDBC =>
        buildDataFrameFromJDBC(connectionManager, reader, loadTable.path, loadTable.properties)

      case Constants.PARQUET | Constants.ORC | Constants.JSON | Constants.AVRO => // parquet/orc/json file
        reader.format(format).load(loadTable.path)

      case Constants.CSV | Constants.TSV => // csv/tsv
        buildDataFrameFromText(reader, format, loadTable.path, loadTable.properties)

      case Constants.TXT =>
        buildDataFrameFromText(sparkSession, loadTable.path, loadTable.properties)

      case Constants.HBASE => // hbase
        buildDataFrameFromHBase(reader, loadTable.path, loadTable.properties)

      case _ if inputFormat != null =>
        inputFormat.run(loadTable)

      case _ => throw new SparkException("Unsupported SQL format")
    }

    df.createOrReplaceTempView(tableName)

    val fieldNames = List[String]("Column", "Type", "Null")
    val data = df.schema.map(f => List(f.name, f.dataType.typeName, f.nullable.toString)).toList
    SparkUtils.toResult(fieldNames, data)

    df.show()
  }

  protected override def loadIntoTable(dataLinkSession: DataLinkSession, loadTable: LoadTable): Unit = {
    val dataLinkSparkSession = dataLinkSession.asInstanceOf[DataLinkSparkSession]
    val sparkSession = dataLinkSparkSession.sparkSession

    val tableName = loadTable.tableIdentifier.getTableName()

    require(!Strings.isNullOrEmpty(tableName), "LoadIntoTable tableName is null")

    if (!dataLinkSparkSession.checkTableExists(sparkSession, tableName)) {
      throw new SparkException(s"${tableName} is not exists")
    }

    val reader = sparkSession.sqlContext.read

    val inputFormat = getInputFormat(PropertiesUtils.getString(loadTable.properties, "inputFormatClass"))

    val format = loadTable.format.toLowerCase

    var df: DataFrame = format match {
      case Constants.HIVE =>
        sparkSession.table(loadTable.path)

      case Constants.JDBC =>
        buildDataFrameFromJDBC(dataLinkSession.connectionManager,
          reader, loadTable.path, loadTable.properties)

      case Constants.PARQUET | Constants.ORC | Constants.JSON =>
        reader.format(format).load(loadTable.path)

      case Constants.CSV | Constants.TSV =>
        buildDataFrameFromText(reader, loadTable.format, loadTable.path, loadTable.properties)

      case Constants.HBASE =>
        buildDataFrameFromHBase(reader, loadTable.path, loadTable.properties)

      case _ if inputFormat != null =>
        inputFormat.run(loadTable)

      case _ => throw new SparkException("Unsupported SQL format")
    }

    val tmpTable = s"tmp_${tableName}_${System.currentTimeMillis()}"
    df.createOrReplaceTempView(tableName)
    df.printSchema()

    val columns = df.schema.map(f => {
      f.name
    }).toList.mkString(", ")

    var enableDynamicPartition = false
    val partitions = if (loadTable.partitionSpec != null && !loadTable.partitionSpec.isEmpty) {
      loadTable.partitionSpec.map(p => {
        if (!Strings.isNullOrEmpty(p._1) && !Strings.isNullOrEmpty(p._2)) {
          s"${p._1}='${p._2}'"
        } else if (!Strings.isNullOrEmpty(p._1) && Strings.isNullOrEmpty(p._2)) {
          enableDynamicPartition = true
          s"${p._1}"
        } else ""
      }).mkString(", ")
    } else ""

    val insertMode = if (loadTable.isOverWrite) "OVERWRITE" else "INTO"

    if (enableDynamicPartition) {
      sparkSession.sql("set hive.exec.dynamic.partition.mode=nonstrict")
    }

    df = sparkSession.sql(s"insert ${insertMode} table ${tableName} ${partitions} select ${columns} from ${tmpTable}")

    if (enableDynamicPartition) {
      sparkSession.sql("set hive.exec.dynamic.partition.mode=strict")
    }

    SparkUtils.toResult(df)
  }


  private def tmpTableName = s"tmp_table_${System.currentTimeMillis()}"

  /**
    * build datafrome from text
    *
    * @param reader
    * @param format
    * @param path
    * @param properties
    * @return
    * <p>
    * delimiter：指定分隔符
    * header：是否设置头部信息
    * colNames：指定列名，中间使用","进行分割
    * </p>
    */
  def buildDataFrameFromText(reader: DataFrameReader,
                             format: String,
                             path: String,
                             properties: Properties): DataFrame = {
    val delimiter = format match {
      case "csv" => properties.getProperty("delimiter", ",")
      case "tsv" => properties.getProperty("delimiter", "\t")
      case _ => properties.getProperty("delimiter", ",")
    }

    val header = properties.getProperty("header", "false")

    var cols: Seq[String] = null
    val colNames = properties.getProperty("colNames", "")
    if (header.toBoolean || !Strings.isNullOrEmpty(colNames)) { // 需要设置头部
      // 将预设的列名按照","进行分割
      cols = colNames.split(",", -1).map(_.trim).toSeq
    }

    val options = scala.collection.mutable.Map[String, String]()

    options += ("delimiter" -> delimiter)
    // 是否设置头部
    if (!Strings.isNullOrEmpty(header) || (cols != null)) {
      options += ("header" -> header)
    }
    if (options.contains("inferSchema")) { // 推断数据类型
      options += ("inferSchema" -> options("inferSchema"))
    }

    val df = reader.format("csv").options(options.toMap).csv(path)

    if (cols != null) { // 使用自定义列
      df.toDF(cols: _*)
    } else { // 使用默认列名
      df.toDF()
    }
  }


  def addGrokPattern(grok: Grok, properties: Properties): Unit = {
    val patternEx = Pattern.compile(Constants.GROK_ADD_PATTERN)
    if (properties == null) {
      return
    }
    properties.foreach(x => {
      val matcher = patternEx.matcher(x._1)
      if (matcher.find()) {
        grok.addPattern(matcher.group(1), x._2)
      }
    })
  }

  def buildDataFrameFromText(sparkSession: SparkSession,
                             path: String,
                             properties: Properties): DataFrame = {
    val pattern: String =
      if (properties != null && properties.containsKey(Constants.GROK_COMPILE_PATTERN))
        properties.getProperty(Constants.GROK_COMPILE_PATTERN)
      else ""

    require(!Strings.isNullOrEmpty(pattern), s"${Constants.GROK_COMPILE_PATTERN} is null")

    val grok = new Grok
    addGrokPattern(grok, properties)

    grok.compile(pattern)
    val gFields = grok.getFields().toSeq

    require(gFields != null && gFields.size > 0, s"${Constants.GROK_COMPILE_PATTERN} field is null")

    val dataset = sparkSession.sparkContext.textFile(path)

    val fields = gFields.map(field => StructField(field, StringType, nullable = true))
    val schema = StructType(fields)

    val rdd = dataset.map { line =>
      val result = grok.`match`(line)
      val columnArray = new Array[String](gFields.size)

      gFields.zipWithIndex.foreach {
        case (f, index) => {
          columnArray(index) = result.capture.get(f)
        }
      }
      Row.fromSeq(columnArray)
    }
    sparkSession.createDataFrame(rdd, schema)
  }

  /**
    * build dataframe from jdbc
    *
    * @param reader
    * @param path
    * @param properties
    * @return
    * <p>
    * driver：数据库驱动
    * url：访问数据库url
    * user：访问数据库的用户名
    * password：访问数据库的密码
    * </p>
    */
  def buildDataFrameFromJDBC(connectionManager: ConnectionManager,
                             reader: DataFrameReader,
                             path: String,
                             properties: Properties): DataFrame = {

    val connectionName = properties.getProperty("connection", "")
    var driver: String = null
    var url: String = null

    var props: Properties = null

    if (Strings.isNullOrEmpty(connectionName) && properties != null) {
      driver = properties.getProperty(Constants.JDBC_DRIVER, "")
      url = properties.getProperty(Constants.JDBC_URL, "")
      props = properties
    } else {
      val connectionDesc = connectionManager.getConnectionDescription(connectionName)
      require(connectionDesc != null, "connection is not exists")
      val connectionProps = connectionDesc.properties
      if (connectionProps != null) {
        driver = connectionProps.getProperty(Constants.JDBC_DRIVER, "")
        url = connectionProps.getProperty(Constants.JDBC_URL, "")
        props = connectionProps
      }
    }

    require(!Strings.isNullOrEmpty(driver), "jdbc.driver is null")
    require(!Strings.isNullOrEmpty(url), "jdbc.url is null")

    try {
      Class.forName(driver)
    } catch {
      case e: Exception => throw new SparkException(e.getMessage)
    }

    val table = if (path.toLowerCase.trim.startsWith("select ")) {
      s"(${path}) ${tmpTableName}"
    } else path

    reader.jdbc(url, table, props)
  }


  def getInputFormat(inputFormatClass: String): InputFormat = {
    if (!Strings.isNullOrEmpty(inputFormatClass)) {
      try {
        Class.forName(inputFormatClass).newInstance().asInstanceOf[InputFormat]
      } catch {
        case e: Exception =>
          throw new SparkException(s"Cannot load class ${inputFormatClass}")
      }
    } else null
  }


  /**
    * build dataframe from hbase
    *
    * @param reader
    * @param tableName
    * @param properties
    * @return
    * <p>
    * hbase.zookeeper.quorum：       zookeeper地址
    * spark.hbase.columns.mapping：  hbase表和spark表列映射关系，可替代spark.table.schema和hbase.table.schema
    * hbase.table.name：             hbase数据源表名
    * spark.table.name：             加载的spark表名
    * spark.table.schema：           加载的spark表的schema，需要与hbase.table.schema对应，并同时配置
    * hbase.table.rowkey.field：     指定rowkey所对的列，不设置的话，会自动去寻找名为rowkey的列
    * hbase.table.schema：           被加载的hbase表的schema，需要与spark.table.schema对应，并同时配置
    * bulkload.enable：              是否启用bulkload模式，默认不启动，当要插入的hbase表只有rowkey列的时候，必须启动
    * hbase.check.table：            检查hbase表是否存在，默认false，在设置true的时候，如果hbase的表不存在，则会创建
    * hbase.table.family：           列族名，默认为info
    * hbase.table.region.num：       分区个数
    * hbase.table.startkey：         预分区开始的key，当hbase表不存在的时候，需要创建hbase表时启用
    * hbase.table.endkey：           预分区结束的key
    * </p>
    */
  def buildDataFrameFromHBase(reader: DataFrameReader,
                              tableName: String,
                              properties: Properties): DataFrame = {
    var options = Utils.convertPropToMap(properties)
    options += ("hbase.table.name" -> tableName)
    reader.format("hbase")
      .options(options).load()
  }
}





