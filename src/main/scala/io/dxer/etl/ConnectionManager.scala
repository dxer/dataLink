package io.dxer.etl

import java.util.{Collections, Properties, HashMap => JHashMap}

import io.dxer.etl.sql.tree.Connection
import io.dxer.etl.util.ZkClient
import org.apache.spark.SparkException
import org.apache.zookeeper.CreateMode

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer

object ConnectionManager {

  private val connectionMap = Collections.synchronizedMap[String, ConnectionDescription](new JHashMap())

  private val forbiddenConnectName = List[String](
    "hive", "csv", "tcv", "text"
  )

  val CONNECTION_DIR = "/spark-etl/connection"

  val zkClient = new ZkClient(SparkSessionHolder.sparkSession.sparkContext.getConf)

  if (zkClient.enable()) {
    if (zkClient.checkExists(CONNECTION_DIR)) {
      val paths = zkClient.getChildren(CONNECTION_DIR)
      if (paths != null && paths.size() > 0) {
        paths.map(path => {
          zkClient.getData[ConnectionDescription](CONNECTION_DIR + "/" + path)
        }).filter(c => c != None && c.get != null).foreach(c => {
          try {
            connectionMap.put(c.get.name, c.get)
          } catch {
            case e: Exception => e.printStackTrace()
          }
        })
      }
    } else {
      zkClient.createNode(CONNECTION_DIR, CreateMode.PERSISTENT)
    }
  }

  def addConnect(connect: Connection): Unit = {
    connectionMap.synchronized {
      val connectionDescription = convert(connect)
      if (!isforbidden(connectionDescription.name)) {
        connectionMap.put(connectionDescription.name, connectionDescription)
        if (zkClient.enable() && !connect.isTempConnection) {
          zkClient.createNode(CONNECTION_DIR + "/" + connectionDescription.name,
            CreateMode.PERSISTENT,
            connectionDescription)
        }
      } else {
        throw new SparkException(s"${connect.getName} is forbidden, please use other name")
      }
    }
  }

  def removeConnect(name: String): Unit = {
    connectionMap.synchronized {
      val delete = ArrayBuffer[String]()
      connectionMap.foreach(x => {
        if (x._1.equalsIgnoreCase(name)) {
          delete += x._1
        }
      })
      delete.foreach(x => {
        val connectionDescription = connectionMap.remove(x)
        if (zkClient.enable() && !connectionDescription.isTemp) {
          zkClient.deleteNode(CONNECTION_DIR + "/" + connectionDescription.name)
        }
      })
    }
  }

  def getConnectByName(name: String): ConnectionDescription = {
    connectionMap.foreach(x => {
      if (x._1.equalsIgnoreCase(name)) {
        return x._2
      }
    })
    null
  }

  def getAllConections(): java.util.Collection[ConnectionDescription] = {
    connectionMap.values()
  }

  def contains(name: String): Boolean = {
    connectionMap.synchronized {
      connectionMap.foreach(x => {
        if (x._1.equalsIgnoreCase(name)) {
          return true
        }
      })
    }
    false
  }

  private def isforbidden(name: String): Boolean = {
    forbiddenConnectName.foreach(n => {
      if (n.toLowerCase.equalsIgnoreCase(name)) {
        return true
      }
    })
    false
  }

  def show(): Unit = {
    connectionMap.foreach(x => {
      println(x)
    })
  }

  def convert(connect: Connection): ConnectionDescription = {
    new ConnectionDescription(connect.getName, connect.getConnectionType.getName, connect.isTempConnection, connect.getProperties)
  }

}


@SerialVersionUID(-4486938584926174252L)
class ConnectionDescription(val name: String,
                            val connectionType: String,
                            val isTemp: Boolean,
                            val properties: Properties) extends Serializable {


  override def toString: String = s"ConnectionDescription (${name})"

}