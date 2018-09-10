package io.dxer.etl.operator

import java.util.Properties

import com.google.common.base.Strings
import io.dxer.etl.ConnectionManager
import io.dxer.etl.operator.input.InputFormat
import io.dxer.etl.sql.tree.Load
import io.dxer.etl.util.{PropertiesUtils, Utils}
import org.apache.spark.SparkException
import org.apache.spark.sql.{DataFrame, DataFrameReader, SparkSession}

/**
  * 将parquet/json/csv/tsv/text/jdbc/hive等方式加载成表
  *
  * @param sparkSession
  * @param load
  */
class LoadOperator(sparkSession: SparkSession, load: Load) extends Operator {

  override def exec(): Unit = {
    val format = load.getFormat
    var path = load.getPath
    val properties = load.getProperties
    val tableName = load.getTableName
    val isLocal = load.isLocal

    if (isLocal && !path.startsWith("file:///")) {
      path = "file:///" + path
    }

    val reader = sparkSession.read

    var df: DataFrame = null

    val inputFormatClass = PropertiesUtils.getString(properties, "inputFormatClass")

    val inputFormat: InputFormat = if (!Strings.isNullOrEmpty(inputFormatClass)) {
      try {
        Class.forName(inputFormatClass).newInstance().asInstanceOf[InputFormat]
      } catch {
        case e: Exception =>
          throw new SparkException(s"Cannot load class ${inputFormatClass}")
      }
    } else null


    format.toLowerCase match {
      case _ if inputFormat != null =>
        df = inputFormat.run(load)

      case "parquet" =>
        df = reader.parquet(path)

      case "json" =>
        df = reader.json(path)

      case _ if Utils.isSimpleText(format) => // text/csv/tsv
        df = buildDataFrameFromText(reader, format, path, properties)

      case _ if ConnectionManager.contains(format) =>
        df = buildDataFrameFromJDBC(reader, format, path, properties)

      case "hive" =>
        df = sparkSession.sql(s"select * from ${path}")

      case "hbase" =>
        buildDataFrameFromHBase(reader, path, properties)

      case _ =>
        throw new SparkException("Not support Load task")
    }

    if (df != null) {
      df.createOrReplaceTempView(tableName)
      df.printSchema()
      setResult("OK")
    }
  }

  /**
    * 将csv/text/json文本内容转化为DataFrame
    *
    * @param reader
    * @param format
    * @param path
    * @param properties
    * @return
    */
  private def buildDataFrameFromText(reader: DataFrameReader,
                                     format: String,
                                     path: String,
                                     properties: Properties): DataFrame = {
    // get delimiter by format
    val delimiter = format.toLowerCase match {
      case "csv" => PropertiesUtils.getString(properties, "delimiter", ",")
      case "tsv" => PropertiesUtils.getString(properties, "delimiter", "\t")
      case "text" => PropertiesUtils.getString(properties, "delimiter", ",")
    }

    val header = PropertiesUtils.getString(properties, "header", "false")

    var cols: Seq[String] = null
    val colNames = PropertiesUtils.getString(properties, "colNames")
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
    if (properties.containsKey("inferSchema")) { // 推断数据类型
      options += ("inferSchema" -> properties.getProperty("inferSchema"))
    }

    val df = reader.format("csv").options(options.toMap).csv(path)

    if (cols != null) { // 使用自定义列
      df.toDF(cols: _*)
    } else { // 使用默认列名
      df.toDF()
    }
  }

  /**
    * 以jdbc方式将数据源转化为DataFrame
    *
    * @param reader
    * @param format
    * @param path , 支持table和pushdown_query
    * @param properties
    * @return
    */
  private def buildDataFrameFromJDBC(reader: DataFrameReader,
                                     format: String,
                                     path: String,
                                     properties: Properties): DataFrame = {
    val connection = ConnectionManager.getConnectByName(format)
    if (connection == null)
      throw new SparkException("connect is not exists")

    val driver = connection.properties.getProperty("driver")
    val url = connection.properties.getProperty("url")
    Class.forName(driver)

    // method 1

    //    val options = Map[String, String](
    //      "driver" -> properties.getProperty("driver"),
    //      "url" -> properties.getProperty("url"),
    //      "dbtable" -> path,
    //      "user" -> properties.getProperty("user"),
    //      "password" -> properties.getProperty("password")
    //    )
    //
    //    reader.format("jdbc").options(options).load()

    // method 2
    val table = if (path.toLowerCase.trim.startsWith("select ")) {
      s"(${path}) _tmp_"
    } else path

    reader.jdbc(url, table, connection.properties)
  }

  /**
    *
    * @param reader
    * @param tableName
    * @param properties
    * @return
    */
  private def buildDataFrameFromHBase(reader: DataFrameReader, tableName: String, properties: Properties): DataFrame = {
    var options = Utils.convertPropToMap(properties)
    options += ("hbase.table.name" -> tableName)
    reader.format("org.apache.spark.sql.execution.datasources.hbase")
      .options(options).load()
  }
}