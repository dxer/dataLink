package io.dxer.datalink.sql.parser

import java.util.Properties

class NodeLocation(val line: Int, val charPositionInLine: Int)

abstract class Node(var location: Option[NodeLocation]) {

  //def getChildren(): List[Node]

  override def hashCode(): Int = super.hashCode()

  override def equals(obj: Any): Boolean = super.equals(obj)

  override def toString: String = super.toString
}

abstract class Statement(location: Option[NodeLocation]) extends Node(location)

abstract class Expression(location: Option[NodeLocation]) extends Node(location)

class Statements(location: NodeLocation, statementList: List[Statement]) extends Node(Option(location)) {
  def this(statementList: List[Statement]) {
    this(null, statementList)
  }
}

abstract class ConnectionStatement(location: NodeLocation) extends Statement(Option(location))

class CreateConnection(location: NodeLocation,
                       val isTemp: Boolean,
                       val connectionType: String,
                       val name: String,
                       val properties: Properties) extends ConnectionStatement(location)

class DropConnection(location: NodeLocation,
                     val isTemp: Boolean,
                     val connectionType: String,
                     val name: String) extends ConnectionStatement(location)

class ShowCreateConnection(location: NodeLocation,
                           val connectionType: String,
                           val name: String) extends ConnectionStatement(location)

class ShowConnections(location: NodeLocation,
                      val connectionType: String,
                      val pattern: String) extends ConnectionStatement(location)

case class TableIdentifier(table: String, database: Option[String]) {
  def this(table: String) = this(table, None)

  def getTableName(): String = {
    if (database != None) {
      s"${database.get}.${table}"
    } else {
      table
    }
  }
}

class LoadTable(location: NodeLocation,
                val local: Boolean,
                val format: String,
                val path: String,
                val properties: Properties,
                val isIntoTable: Boolean,
                val isOverWrite: Boolean,
                val tableIdentifier: TableIdentifier,
                val partitionSpec: Map[String, String]) extends Statement(Option(location))


class InsertInto(location: NodeLocation,
                 val isOverWrite: Boolean,
                 val isLocal: Boolean,
                 val format: String,
                 val path: String,
                 val properties: Properties,
                 val tableName: String,
                 val query: String) extends Statement(Option(location)) {

}

class QueryAsTable(location: NodeLocation, val query: String, val table: String) extends Statement(Option(location))

class OriginSQL(val sql: String) extends Statement(None)

class ExecFunc(location: NodeLocation,
               val func: String,
               val params: Seq[Any]) extends Statement(Option(location))
