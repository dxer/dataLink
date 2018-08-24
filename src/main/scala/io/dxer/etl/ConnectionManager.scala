package io.dxer.etl

import com.google.gson.Gson
import io.dxer.etl.sql.tree.Connection
import org.apache.spark.SparkException

object ConnectionManager {

  private val map = scala.collection.mutable.Map[String, Connection]()

  private val forbiddenConnectName = List[String](
    "hive", "csv", "tcv", "text"
  )

  val gson = new Gson()

  def addConnect(connect: Connection): Unit = {
    if (!isforbidden(connect.getName)) {
      map += (connect.getName -> connect)
    } else {
      throw new SparkException(s"${connect.getName} is forbidden, please use other name")
    }
  }

  def removeConnect(name: String): Unit = {
    map.remove(name)
  }

  def getConnectByName(name: String): Connection = {
    map.getOrElse(name, null)
  }

  def contains(name: String): Boolean = {
    map.contains(name)
  }

  private def isforbidden(name: String): Boolean = {
    forbiddenConnectName.foreach(n => {
      if (n.toLowerCase.equalsIgnoreCase(name)) {
        return true
      }
    })
    false
  }

  def clear(): Unit = {
    map.clear()
  }

  def size(): Int = {
    map.size
  }

  def show(): Unit = {
    map.foreach(x => {
      println(gson.toJson(x._2))
    })
  }

}
