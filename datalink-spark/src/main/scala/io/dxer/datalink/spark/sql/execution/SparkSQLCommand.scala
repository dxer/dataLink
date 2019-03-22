package io.dxer.datalink.spark.sql.execution

import io.dxer.datalink.spark.DataLinkSparkSession
import io.dxer.datalink.spark.output.ConsolePrinter
import io.dxer.datalink.spark.util.SparkUtils
import io.dxer.datalink.sql.DataLinkSession
import io.dxer.datalink.sql.execution.RunnableCommand
import io.dxer.datalink.sql.parser.OriginSQL

class SparkSQLCommand(originSQL: OriginSQL) extends RunnableCommand {

  override def run(dataLinkSession: DataLinkSession): Unit = {
    val sparkSession = dataLinkSession.asInstanceOf[DataLinkSparkSession].sparkSession
    val df = sparkSession.sql(originSQL.sql)

    //    df.printSchema()
    //    df.collect().foreach(println)

    //    val fieldNames = List[String]("Column", "Type", "Null")
    //
    //    val list = df.schema.map(f => List(f.name, f.dataType.typeName, f.nullable.toString)).toList

    val fieldNames = df.schema.map(f => f.name).toList

    val result = if (df.collect().size > 1000) {
      df.collect().take(1000)
    } else {
      df.collect()
    }

    val data = result.map(row => {
      df.schema.map(f => {
        SparkUtils.getFromRow(row, f.dataType, f.name)
      }).toList
    }).toList

    ConsolePrinter(fieldNames, true, System.out).printRows(data)
  }
}
