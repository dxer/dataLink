package io.dxer.etl.util

import com.google.common.base.Strings
import org.apache.curator.framework.{CuratorFramework, CuratorFrameworkFactory}
import org.apache.curator.retry.ExponentialBackoffRetry
import org.apache.spark.SparkConf
import org.apache.spark.internal.Logging

object ZKUtils extends Logging {

  var zk: CuratorFramework = null

  private val ZK_CONNECTION_TIMEOUT_MILLIS = 15000
  private val ZK_SESSION_TIMEOUT_MILLIS = 60000
  private val RETRY_WAIT_MILLIS = 5000
  private val MAX_RECONNECT_ATTEMPTS = 3

  def newClient(conf: SparkConf, zkUrlConf: String = "spark.deploy.zookeeper.url"): CuratorFramework = {
    if (zk == null) {
      val ZK_URL = conf.get(zkUrlConf)
      require(!Strings.isNullOrEmpty(ZK_URL), "zk_url is null")
      logInfo(s"zookeerper address is ${ZK_URL}")
      zk = CuratorFrameworkFactory.builder()
        .connectString(ZK_URL)
        .sessionTimeoutMs(ZK_SESSION_TIMEOUT_MILLIS)
        .connectionTimeoutMs(ZK_CONNECTION_TIMEOUT_MILLIS)
        .retryPolicy(new ExponentialBackoffRetry(RETRY_WAIT_MILLIS, MAX_RECONNECT_ATTEMPTS))
        .build()

      zk.start()
      zk
    } else zk
  }


}
