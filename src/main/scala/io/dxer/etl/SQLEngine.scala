package io.dxer.etl

import com.google.common.base.Strings
import io.dxer.etl.operator._
import io.dxer.etl.sql.exception.ParsingException
import io.dxer.etl.sql.parser.{ParsingOptions, SqlParser}
import io.dxer.etl.sql.tree._
import org.apache.spark.SparkException
import org.apache.spark.internal.Logging
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.parser.CatalystSqlParser

object SQLEngine extends Logging {

  val parser = new SqlParser()

  def execute(sparkSession: SparkSession, sqlText: String): OperResult = {
    require(sparkSession != null, "spark session is null")
    require(!Strings.isNullOrEmpty(sqlText), "sqlText is null")

    var st: Statement = null
    try
      st = parser.createStatement(sqlText, new ParsingOptions)
    catch {
      case e: ParsingException =>
        log.error(s"sql parse error<${sqlText}>", e)
        throw e
    }

    val oper: Operator = st match {
      case st if st.isInstanceOf[FileOper] => new FileOperator(sparkSession, st.asInstanceOf[FileOper])
      case st if st.isInstanceOf[Connection] => new ConnectOperator(st.asInstanceOf[Connection])
      case st if st.isInstanceOf[Load] => new LoadOperator(sparkSession, st.asInstanceOf[Load])
      case st if st.isInstanceOf[Save] => new SaveOperator(sparkSession, st.asInstanceOf[Save])
      case st if st.isInstanceOf[QueryAsTable] => new QueryAsTableOperator(sparkSession, st.asInstanceOf[QueryAsTable])
      case st if st.isInstanceOf[InsertInto] => new InsertIntoOperator(sparkSession, st.asInstanceOf[InsertInto])
      case st if st.isInstanceOf[CmdOper] => new CmdOperator(st.asInstanceOf[CmdOper])
      case st if verify(sparkSession, sqlText) => new SQLOperator(sparkSession, sqlText)
      case _ => throw new SparkException("Not support operator")
    }

    oper.tryExec()
  }

  /**
    * 校验sql是否符合spark sql语法
    *
    * @param sparkSession
    * @param sqlText
    * @return
    */
  def verify(sparkSession: SparkSession, sqlText: String): Boolean = {
    try {
      new CatalystSqlParser(sparkSession.sessionState.conf).parsePlan(sqlText)
      true
    } catch {
      case e: Exception =>
        e.printStackTrace()
        false
    }
  }

  def main(args: Array[String]): Unit = {
    val sqlText = "select * from haifeng.wo_flow limit 10 as ttttt"
    var st: Statement = null
    try
      st = parser.createStatement(sqlText, new ParsingOptions)
    catch {
      case e: ParsingException => e.printStackTrace()
    }
  }
}
