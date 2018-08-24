package io.dxer.etl

import io.dxer.etl.sql.parser.{ParsingOptions, SqlParser}
import io.dxer.etl.sql.tree.Connection

object SqlTest {

  def main(args: Array[String]): Unit = {
    val sql = "create  connect oracle (a=1,driver = 'oracle.jdbc.driver.OracleDriver', url = 'jdbc:oracle:thin:@192.168.32.49:1521:dcdb12', user = 'ulams', password = 'q_tk_ulams', dbtable = 'yuwu.t_province_code')"
    val parser = new SqlParser()
    val st = parser.createStatement(sql, new ParsingOptions)
    if (st != null) {
      val tt = st.asInstanceOf[Connection]
      println(tt.getProperties.getProperty("a"))
    }
  }
}
