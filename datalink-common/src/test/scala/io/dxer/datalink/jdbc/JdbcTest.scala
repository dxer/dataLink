package io.dxer.datalink.jdbc

import java.sql.{Connection, DriverManager}

import io.dxer.datalink.jdbc.StatementIO._
import io.dxer.datalink.jdbc.{Mapping, StatementIO}


case class User(id: Int, username: String, password: String)

case class Article(id: Int, title: String, content: String, userID: Int)


object JdbcTest {

  def conn = DriverManager.getConnection("")

  implicit def mappingUser = Mapping(
    l => {
      val id = l(0).toInt
      val username = l(1)
      val password = l(2)
      User(id, username, password)
    }
  )

  def deleteUser(id: Int)(conn: Connection): Either[Exception, (Int, Int)] = {
    val delUser =
      for {
        delArticleCount <- StatementIO("delete from article where userID = ?", List(id)).update
        delUserCount <- StatementIO("delete from user where id = ?", List(id)).update
      } yield (delArticleCount, delUserCount)
    delUser.transact(conn)
  }


  def addUser(user: User)(conn: Connection): Either[Exception, Int] =
    StatementIO("insert into user (username, password) values (?, ?)",
      List(user.username, user.password)).update.run(conn)


  def getUser(id: Int)(conn: Connection): Either[Exception, User] =
    sql"select id, username, password from user where id = $id"
      .query.unique.run(conn)

  def main(args: Array[String]): Unit = {
    StatementIO("delete from article where userId = ?", List("test")).update.run(conn)


    StatementIO("select id, username, password from user where id = ?", List(1))
      .query(mappingUser).unique.run(conn)

    StatementIO("select id, username, password from user where id = ?", List(1))
      .queryObject[User].unique.run(conn)

  }
}
