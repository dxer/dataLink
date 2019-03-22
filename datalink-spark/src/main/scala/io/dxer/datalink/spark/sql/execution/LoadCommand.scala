package io.dxer.datalink.spark.sql.execution

import java.util.Properties

import com.google.common.base.Strings
import io.dxer.datalink.grok.Grok
import io.dxer.datalink.spark.Constants
import io.dxer.datalink.sql.ConnectionManager
import io.dxer.datalink.sql.execution.RunnableCommand
import io.dxer.datalink.util.Utils
import org.apache.spark.SparkException
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, DataFrameReader, Row, SparkSession}

import scala.collection.JavaConversions._

abstract class LoadCommand extends RunnableCommand {

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

  def buildDataFrameFromText(sparkSession: SparkSession,
                             path: String,
                             properties: Properties): DataFrame = {
    val pattern = if (properties.contains(Constants.GROK_PATTERN))
      properties.getProperty(Constants.GROK_PATTERN)
    else null

    require(!Strings.isNullOrEmpty(pattern), "grok.pattern is null")

    val grok = new Grok
    grok.compile(pattern)
    val gFields = grok.getFields().toSeq

    require(gFields != null && gFields.size > 0, "grok.pattern field is null")

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





