package io.dxer.datalink.sql

import java.sql.Connection
import java.util.Properties
import java.util.regex.PatternSyntaxException

import com.google.common.base.Strings
import io.dxer.datalink.exception.DataLinkException
import io.dxer.datalink.jdbc.Database
import io.dxer.datalink.sql.parser.CreateConnection
import io.dxer.datalink.util.PropertiesUtils

import scala.collection.mutable

/**
  *
  */
class ConnectionManager {

  private val connectionDefinitions = new mutable.HashMap[String, ConnectionDescription]

  def init(): Unit = {

  }

  /**
    * exist
    *
    * @param name
    * @return
    */
  def exist(name: String): Boolean = synchronized {
    connectionDefinitions.contains(name)
  }

  /**
    * getConnectionDescription connection Type
    *
    * @param name
    * @return
    */
  def getConnectionType(name: String): String = synchronized {
    val connectionDescription = getConnectionDescription(name)
    if (connectionDescription == null) {
      throw new DataLinkException(s"connection<${name}> is not exists")
    } else {
      connectionDescription.connectionType
    }
  }

  /**
    *
    * @param name
    * @return
    */
  def isJDBCConnection(name: String): Boolean = synchronized {
    val connectionDescription = getConnectionDescription(name)
    if (connectionDescription != null) {
      connectionDescription.connectionType.equals("JDBC")
    } else {
      false
    }
  }

  def getConnectionDescription(name: String): ConnectionDescription = synchronized {
    if (connectionDefinitions.contains(name)) {
      return connectionDefinitions(name)
    }
    null
  }

  /**
    * create connection
    *
    * @param conn
    */
  def createConnection(conn: CreateConnection): Unit = synchronized {
    if (exist(conn.name)) {
      throw new DataLinkException(conn.name)
    }

    // put connection into zookeeper
    if (!conn.isTemp) {

    }
    connectionDefinitions.put(conn.name, new ConnectionDescription(conn))
  }

  /**
    *
    * @param name
    * @return
    */
  def remove(name: String): Boolean = synchronized {
    if (exist(name)) {
      // remove from zookeeper
      connectionDefinitions.remove(name)
      return true
    }

    false
  }

  /**
    * list connections
    *
    * @param connectionType
    * @param pattern
    * @return
    */
  def listConnections(connectionType: String, pattern: String): Seq[String] = synchronized {
    val funcNames = scala.collection.mutable.SortedSet.empty[String]
    if (!Strings.isNullOrEmpty(pattern)) {
      pattern.trim().split("\\|").foreach { subPattern =>
        try {
          val regex = ("(?i)" + subPattern.replaceAll("\\*", ".*")).r
          //        funcNames ++= connectionDefinitions.keys.toSeq
          //          .filter(name => name.startsWith(connectionType + "_") && regex.pattern.matcher(name).matches())

          funcNames ++= connectionDefinitions.toSeq.filter(x => {
            regex.pattern.matcher(x._1).matches() && x._2.connectionType.equals(connectionType)
          }).map(x => s"${x._2.connectionType}#${x._1}")

        } catch {
          case _: PatternSyntaxException =>
        }
      }
    } else {
      funcNames ++= connectionDefinitions.toSeq.map(x => s"${x._2.connectionType}#${x._1}")
    }

    funcNames.toSeq.foreach(println)

    funcNames.toSeq
  }

  /**
    * getConnectionDescription jdbc connection
    *
    * @param name connection name
    * @return
    */
  def getJDBCConnection(name: String): Connection = synchronized {
    val desc = getConnectionDescription(name)
    if (desc == null) {
      throw new Exception(s"JDBC Connection ${name} is not exist")
    }

    val url = PropertiesUtils.getString(desc.properties, "url")
    Database.forURL(url, desc.properties).getConnection
  }

}


object ConnectionManager {
  def apply: ConnectionManager = new ConnectionManager()
}

case class ConnectionDescription(connectionType: String, name: String,
                                 isTemp: Boolean,
                                 properties: Properties) extends Serializable {
  def this(connectionType: String, name: String) {
    this(connectionType, name, true, new Properties)
  }

  def this(conn: CreateConnection) {
    this(conn.connectionType, conn.name, conn.isTemp, conn.properties)
  }
}

class ConnectionAlreadyExistException(name: String)
  extends Exception(s"Connection '${name}' already exists") {
}

class ConnectionNotExistException(name: String)
  extends Exception(s"Connection '${name}' not exists") {
}

