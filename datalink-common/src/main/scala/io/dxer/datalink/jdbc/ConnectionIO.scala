package io.dxer.datalink.jdbc

import java.sql.Connection


class ConnectionIO[A](func: Connection => A) {

  def map[B](fa: A => B): ConnectionIO[B] = {
    val fb = (conn: Connection) => {
      val a = func(conn)
      fa(a)
    }
    new ConnectionIO(fb)
  }

  def flatMap[B](fa: A => ConnectionIO[B]): ConnectionIO[B] = {
    val fb = (conn: Connection) => {
      val a = func(conn)
      fa(a).extract(conn)
    }
    new ConnectionIO(fb)
  }

  def run(conn: Connection): Either[Exception, A] = {
    try Right(func(conn))
    catch {
      case e: Exception => Left(e)
    } finally {
      if (conn != null) conn.close()
    }
  }

  def transact(conn: Connection): Either[Exception, A] = {
    try {
      conn.setAutoCommit(false)
      val res = extract(conn)
      conn.commit()
      Right(res)
    } catch {
      case e: Exception =>
        conn.rollback()
        Left(e)
    } finally {
      if (conn != null) conn.close()
    }
  }

  private[ConnectionIO] def extract(conn: Connection): A = func(conn)

}

object ConnectionIO {

  def apply[A](func: Connection => A): ConnectionIO[A] = new ConnectionIO(func)

  implicit class ConnectionIOOp[A](ca: ConnectionIO[List[A]]) {

    def list: ConnectionIO[List[A]] = ca

    def unique: ConnectionIO[A] = ca.map(_.head)

    def option: ConnectionIO[Option[A]] = ca.map(_.headOption)

  }

}
