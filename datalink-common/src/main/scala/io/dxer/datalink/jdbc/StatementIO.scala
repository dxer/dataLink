package io.dxer.datalink.jdbc

import java.sql.{Connection, ResultSet}

import scala.reflect._
import scala.reflect.runtime.universe._

trait Mapping[A] extends (List[String] => A)

object Mapping {

  def apply[A](f: List[String] => A) = new Mapping[A] {
    override def apply(v: List[String]): A = f(v)
  }

}

class StatementIO(sql: String, parameters: Seq[Any]) {

  import StatementIO._

  def query[A: Mapping]: ConnectionIO[List[A]] = {
    val f = implicitly[Mapping[A]]
    val fa = (conn: Connection) => {
      val stmt = conn.prepareStatement(sql)
      (1 to parameters.size).zip(parameters).foreach {
        case (i, p) => stmt.setObject(i, p)
      }
      val rs = stmt.executeQuery()
      rs.rows.map(f)
    }
    ConnectionIO(fa)
  }

  def queryObject[A: TypeTag : ClassTag]: ConnectionIO[List[A]] = {
    val fa = (conn: Connection) => {
      val stmt = conn.prepareStatement(sql)
      (1 to parameters.size).zip(parameters).foreach {
        case (i, p) => stmt.setObject(i, p)
      }
      val rs = stmt.executeQuery()
      fromResultSet[A](rs)
    }
    ConnectionIO(fa)
  }


  def update: ConnectionIO[Int] = {
    val fb = (conn: Connection) => {
      val stmt = conn.prepareStatement(sql)
      (1 to parameters.size).zip(parameters).foreach {
        case (i, p) => stmt.setObject(i, p)
      }
      stmt.executeUpdate()
    }
    ConnectionIO(fb)
  }

}


object StatementIO {

  def apply(sql: String, parameters: Seq[Any]): StatementIO = new StatementIO(sql, parameters)

  implicit class ResultSetOp(rs: ResultSet) {

    private val columnLength = rs.getMetaData.getColumnCount

    def columns: List[String] = (1 to columnLength).map(rs.getMetaData.getColumnLabel).toList

    def rows: List[List[String]] = {
      def loop(rs: ResultSet, lines: List[List[String]]): List[List[String]] =
        if (rs.next()) {
          val line = (1 to columnLength).map(rs.getString).toList
          loop(rs, lines :+ line)
        } else lines

      loop(rs, Nil)
    }
  }

  def fromResultSet[A: TypeTag : ClassTag](rs: ResultSet): List[A] = {
    val rm = runtimeMirror(classTag[A].runtimeClass.getClassLoader)
    val classTest = typeOf[A].typeSymbol.asClass
    val classMirror = rm.reflectClass(classTest)
    val constructor = typeOf[A].decl(termNames.CONSTRUCTOR).asMethod
    val constructorMirror = classMirror.reflectConstructor(constructor)
    val paramNames = constructor.paramLists.flatten.map(_.name.toString)

    def loop(rs: ResultSet, res: List[A]): List[A] =
      if (rs.next()) {
        val constructorArgs = paramNames.map(rs.getObject)
        loop(rs, res :+ constructorMirror(constructorArgs: _*).asInstanceOf[A])
      } else
        res

    loop(rs, Nil)
  }


  implicit class SqlHelper(private val sc: StringContext) extends AnyVal {

    def sql(args: Any*): StatementIO = {
      val sql = sc.sqlInterpolator(StringContext.treatEscapes, args)
      new StatementIO(sql, args)
    }


    def sqlInterpolator(process: String => String, args: Seq[Any]): String = {
      sc.checkLengths(args)
      val pi = sc.parts.iterator
      val wi = (1 to args.length).map(_ => "?")
      val ai = wi.iterator
      val bldr = new StringBuilder(process(pi.next()))
      while (ai.hasNext) {
        bldr append ai.next
        bldr append process(pi.next())
      }
      bldr.toString()
    }
  }

}