package io.dxer.datalink.util

import java.util.Properties

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import scala.collection.Map

object Utils {

  def getSystemProperties: Map[String, String] = {
    System.getProperties.stringPropertyNames().asScala
      .map(key => (key, System.getProperty(key))).toMap
  }

  def convertPropToMap(props: Properties): Map[String, String] = {
    if (props != null) props.toMap
    else Map[String, String]()
  }

  /** Get the default classloader to use to dynamically load classes. */
  val defaultClassLoader: ClassLoader = {
    new ClassLoader(this.getClass.getClassLoader) {
      override def loadClass(name: String): Class[_] = {
        try {
          // Try the context classloader first. But, during macro compilation, it's probably wrong, so fallback to this
          // classloader.
          Thread.currentThread().getContextClassLoader.loadClass(name)
        } catch {
          case e: ClassNotFoundException => super.loadClass(name)
        }
      }
    }
  }

}
