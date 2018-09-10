package io.dxer.etl.util

import com.google.common.base.Strings
import org.apache.curator.framework.CuratorFramework
import org.apache.curator.framework.recipes.cache.{NodeCache, NodeCacheListener}
import org.apache.spark.SparkConf
import org.apache.spark.internal.Logging
import org.apache.spark.util.SparkUtils
import org.apache.zookeeper.CreateMode
import org.apache.zookeeper.KeeperException.NoNodeException
import org.apache.zookeeper.data.Stat

import scala.collection.JavaConverters._

class ZkClient(sparkConf: SparkConf) extends Logging {

  private val zk: CuratorFramework = ZKUtils.newClient(sparkConf)

  def enable(): Boolean = {
    if (zk != null) true
    else false
  }

  /**
    *
    * @param path       path
    * @param createMode createMode
    * @param obj        obj
    * @return
    */
  def createNode(path: String, createMode: CreateMode = null, obj: Object = null): Boolean = {
    try {
      val builder = zk.create()

      // create mode is not null
      if (null != createMode) builder.withMode(createMode)

      if (obj != null) { // create a node with data
        val serialized = SparkUtils.serialize(obj)
        builder.creatingParentsIfNeeded.forPath(path, serialized)
      } else { // create a node without data
        builder.creatingParentsIfNeeded.forPath(path)
      }
      true
    } catch {
      case e: Exception => e.printStackTrace()
        false
    }

  }

  def getData[T](path: String): Option[T] = {
    try {
      val data = zk.getData.forPath(path)
      return Some(SparkUtils.deserialize[T](data))
    } catch {
      case e: NoNodeException => None
      case e: Exception => e.printStackTrace()
        None
    }
  }

  def getAllData[T](path: String): Iterable[T] = {
    zk.getChildren.forPath(path).asScala.flatMap(getData[T])
  }

  def updateData(path: String, data: String): Boolean = {
    if (!checkExists(path)) {
      return false
    }
    try {
      if (!Strings.isNullOrEmpty(data)) {
        zk.setData().forPath(path, data.getBytes())
      } else {
        zk.setData().forPath(path)
      }
    } catch {
      case e: Exception => e.printStackTrace()
        return false
    }
    return true

  }

  def deleteNode(path: String): Boolean = {
    try {
      zk.delete().forPath(path)
      return true
    } catch {
      case e: Exception => e.printStackTrace()
    }
    false
  }

  def checkExists(path: String): Boolean = {
    try {
      if (zk.checkExists().forPath(path) != null) return true
    } catch {
      case e: Exception => e.printStackTrace()
    }
    false
  }


  def registerWatcherNodeChanged(path: String, listener: NodeCacheListener): Boolean = {
    val nodeCache = new NodeCache(zk, path, false)
    try {
      nodeCache.getListenable.addListener(listener)
      nodeCache.start(true)
    } catch {
      case e: Exception => e.printStackTrace()
        return false
    }
    return true
  }

  /**
    *
    * @param path
    * @return 2-节点不存在  | 1-是持久化 | 0-临时节点
    */
  def isPersistenNode(path: String): Int = {
    try {
      val stat = zk.checkExists().forPath(path)
      if (null == stat) return 2
      if (stat.getEphemeralOwner > 0) return 1
      return 0
    } catch {
      case e: Exception => e.printStackTrace()
        return 2
    }
  }

  def getChildren(path: String) = {
    zk.getChildren.forPath(path)
  }

}
