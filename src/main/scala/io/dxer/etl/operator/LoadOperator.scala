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


    val read = sparkSession.read

    var df: DataFrame = null

    val inputFormatClass = PropertiesUtils.getString(properties, "inputFormatClass")

    val inputFormat: InputFormat = if (!Strings.isNullOrEmpty(inputFormatClass)) {
      try {
        Class.forName(inputFormatClass).newInstance().asInstanceOf[InputFormat]
      } catch {
        case e: Exception => e.printStackTrace()
          null
      }
    } else null


    format.toLowerCase match {
      case "parquet" => df = read.parquet(path)
      case "json" => df = read.json(path)
      case _ if Utils.isSimpleText(format) => df = buildDFFromText(read, format, path, properties)
      case _ if ConnectionManager.contains(format) => df = buildDFFromJDBC(read, format, path, properties)
      case "hive" => df = sparkSession.sql(s"select * from ${path}")
      case _ if inputFormat != null => df = inputFormat.run(load)
      case _ => throw new SparkException("Not support Load task")
    }

    if (df != null) {
      df.createOrReplaceTempView(tableName)
      df.printSchema()
      setResultMsg(s"LoadOperator success")
    }
  }

  /**
    * 将csv/text/json文本内容转化为DataFrame
    *
    * @param read
    * @param format
    * @param path
    * @param properties
    * @return
    */
  private def buildDFFromText(read: DataFrameReader,
                              format: String,
                              path: String,
                              properties: Properties): DataFrame = {
    // 根据format获取分隔符
    val delimiter = format.toLowerCase match {
      case "csv" => ","
      case "tsv" => "\t"
      case "text" => properties.getProperty("delimiter", ",")
    }

    val header = PropertiesUtils.getString(properties, "header")

    var cols: Seq[String] = null
    val colNames = PropertiesUtils.getString(properties, "colNames")
    if ((!Strings.isNullOrEmpty(header) && header.toBoolean) || !Strings.isNullOrEmpty(colNames)) { // 需要设置头部
      // 将预设的列名按照","进行分割
      cols = colNames.split(",").map(_.trim).toSeq
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

    val df = read.format("csv").options(options.toMap).csv(path)

    if (cols != null) { // 使用自定义列
      df.toDF(cols: _*)
    } else { // 使用默认列名
      df.toDF()
    }
  }

  /**
    * 以jdbc方式将数据源转化为DataFrame
    *
    * @param read
    * @param format
    * @param path , 支持table和pushdown_query
    * @param properties
    * @return
    */
  private def buildDFFromJDBC(read: DataFrameReader,
                              format: String,
                              path: String,
                              properties: Properties): DataFrame = {
    val connect = ConnectionManager.getConnectByName(format)
    if (connect == null)
      throw new SparkException("connect is not exists")

    Class.forName(connect.getDriver())

    // 方式一
    // val props = connect.getProperties
    //    val options = Map[String, String](
    //      "driver" -> props.getProperty("driver"),
    //      "url" -> props.getProperty("url"),
    //      "dbtable" -> table,
    //      "user" -> props.getProperty("user"),
    //      "password" -> props.getProperty("password")
    //    )

    // read.format("jdbc").options(options).load()

    // 方式二
    read.jdbc(connect.getJDBCUrl, path, connect.getConnectionProperties)
  }
}