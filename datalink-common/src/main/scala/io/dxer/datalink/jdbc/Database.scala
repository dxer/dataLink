package io.dxer.datalink.jdbc

import java.util.Properties

import javax.sql.DataSource

object Database {

  def forURL(url: String, driver: String = null, user: String = null, password: String = null, props: Properties = null,
             keepAliveConnection: Boolean = false): DataSource = {
    new DriverDataSource(url, driver, user, password, props, keepAliveConnection)
  }

  def forURL(url: String, props: Properties): DataSource = {
    forURL(url, props = props, driver = null)
  }

}
