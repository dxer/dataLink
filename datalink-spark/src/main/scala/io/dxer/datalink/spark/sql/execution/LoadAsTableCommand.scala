package io.dxer.datalink.spark.sql.execution

import com.google.common.base.Strings
import io.dxer.datalink.exception.DataLinkException
import io.dxer.datalink.spark.util.SparkUtils
import io.dxer.datalink.spark.{Constants, DataLinkSparkSession}
import io.dxer.datalink.sql.DataLinkSession
import io.dxer.datalink.sql.parser.LoadAsTable
import io.dxer.datalink.util.PropertiesUtils
import org.apache.spark.sql.DataFrame

/**
  * LoadAsTableCommand
  *
  * @param loadAsTable
  */
class LoadAsTableCommand(loadAsTable: LoadAsTable) extends LoadCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    val dataLinkSparkSession = dataLinkSession.asInstanceOf[DataLinkSparkSession]
    val sparkSession = dataLinkSparkSession.sparkSession

    val tableName = loadAsTable.tableIdentifier.getTableName()

    require(!Strings.isNullOrEmpty(tableName), "LoadAsTable tableName is null")

    // check table exists
    if (dataLinkSparkSession.checkTableExists(sparkSession, tableName)) {
      throw new DataLinkException(s"${tableName} is exists")
    }

    val connectionManager = dataLinkSession.connectionManager

    val reader = sparkSession.sqlContext.read

    val inputFormat = getInputFormat(PropertiesUtils.getString(loadAsTable.properties, "inputFormatClass"))

    val format = loadAsTable.format.toLowerCase

    val df: DataFrame = format match {
      case Constants.HIVE =>
        sparkSession.table(loadAsTable.path)

      case Constants.JDBC =>
        buildDataFrameFromJDBC(connectionManager, reader, loadAsTable.path, loadAsTable.properties)

      case Constants.PARQUET | Constants.ORC | Constants.JSON | Constants.AVRO => // parquet/orc/json file
        reader.format(format).load(loadAsTable.path)

      case Constants.CSV | Constants.TSV => // csv/tsv
        buildDataFrameFromText(reader, format, loadAsTable.path, loadAsTable.properties)

      case Constants.TXT =>
        buildDataFrameFromText(sparkSession, loadAsTable.path, loadAsTable.properties)

      case Constants.HBASE => // hbase
        buildDataFrameFromHBase(reader, loadAsTable.path, loadAsTable.properties)

      case _ if inputFormat != null =>
        inputFormat.run(loadAsTable)

      case _ => throw new DataLinkException(s"LoadAsTable Not support format: ${loadAsTable.format}")
    }

    df.createOrReplaceTempView(tableName)

    val fieldNames = List[String]("Column", "Type", "Null")
    val data = df.schema.map(f => List(f.name, f.dataType.typeName, f.nullable.toString)).toList
    SparkUtils.toResult(fieldNames, data)
  }


}