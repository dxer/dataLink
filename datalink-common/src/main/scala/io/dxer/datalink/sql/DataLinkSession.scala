package io.dxer.datalink.sql

import org.apache.hadoop.conf.Configuration

class DataLinkSession(var connectionManager: ConnectionManager) {

  var hadoopConf: Configuration = _

  def this(connectionManager: ConnectionManager, conf: Configuration) {
    this(connectionManager)
    this.hadoopConf = conf
  }
}
