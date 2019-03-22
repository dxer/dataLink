package io.dxer.datalink.spark.sql.execution

import com.google.common.base.Strings
import io.dxer.datalink.exception.DataLinkException
import io.dxer.datalink.spark.{Constants, DataLinkSparkSession}
import io.dxer.datalink.sql.DataLinkSession
import io.dxer.datalink.sql.parser.LoadIntoTable
import io.dxer.datalink.util.PropertiesUtils
import org.apache.spark.sql.DataFrame

class LoadIntoTableCommand(loadIntoTable: LoadIntoTable) extends LoadCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    val dataLinkSparkSession = dataLinkSession.asInstanceOf[DataLinkSparkSession]
    val sparkSession = dataLinkSparkSession.sparkSession

    val tableName = loadIntoTable.tableIdentifier.getTableName()

    require(!Strings.isNullOrEmpty(tableName), "LoadIntoTable tableName is null")

    if (!dataLinkSparkSession.checkTableExists(sparkSession, tableName)) {
      throw new DataLinkException(s"${tableName} is not exists")
    }

    val reader = sparkSession.sqlContext.read

    val inputFormat = getInputFormat(PropertiesUtils.getString(loadIntoTable.properties, "inputFormatClass"))

    val format = loadIntoTable.format.toLowerCase

    var df: DataFrame = format match {
      case Constants.HIVE =>
        sparkSession.table(loadIntoTable.path)

      case Constants.JDBC =>
        buildDataFrameFromJDBC(dataLinkSession.connectionManager,
          reader, loadIntoTable.path, loadIntoTable.properties)

      case Constants.PARQUET | Constants.ORC | Constants.JSON =>
        reader.format(format).load(loadIntoTable.path)

      case Constants.CSV | Constants.TSV =>
        buildDataFrameFromText(reader, loadIntoTable.format, loadIntoTable.path, loadIntoTable.properties)

      case Constants.HBASE =>
        buildDataFrameFromHBase(reader, loadIntoTable.path, loadIntoTable.properties)

      case _ if inputFormat != null =>
        inputFormat.run(loadIntoTable)

      case _ => throw new DataLinkException("")
    }

    val tmpTable = s"tmp_${tableName}_${System.currentTimeMillis()}"
    df.createOrReplaceTempView(tableName)
    df.printSchema()

    val columns = df.schema.map(f => {
      f.name
    }).toList.mkString(", ")

    var enableDynamicPartition = false
    val partitions = if (loadIntoTable.partitionSpec != null && !loadIntoTable.partitionSpec.isEmpty) {
      loadIntoTable.partitionSpec.map(p => {
        if (!Strings.isNullOrEmpty(p._1) && !Strings.isNullOrEmpty(p._2)) {
          s"${p._1}='${p._2}'"
        } else if (!Strings.isNullOrEmpty(p._1) && Strings.isNullOrEmpty(p._2)) {
          enableDynamicPartition = true
          s"${p._1}"
        } else ""
      }).mkString(", ")
    } else ""

    val insertMode = if (loadIntoTable.isOverwrite) "OVERWRITE" else "INTO"

    if (enableDynamicPartition) {
      sparkSession.sql("set hive.exec.dynamic.partition.mode=nonstrict")
    }

    df = sparkSession.sql(s"insert ${insertMode} table ${tableName} ${partitions} select ${columns} from ${tmpTable}")

    if (enableDynamicPartition) {
      sparkSession.sql("set hive.exec.dynamic.partition.mode=strict")
    }

    df.schema
  }
}
