package io.dxer.etl.util

import java.io.InputStream
import java.util.Properties

import org.apache.log4j.Logger

object PropertiesUtils {

  val logger = Logger.getLogger(PropertiesUtils.getClass.getName)

  def loadProperties(name: String): Properties = {
    require(name != null, "FileName cannot be null")
    val props: Properties = new Properties
    try {
      val in: InputStream = PropertiesUtils.getClass.getResourceAsStream(name)
      if (in != null) {
        props.load(in)
        logger.info("Properties file " + name + " is loaded successful.")
      }
    } catch {
      case e: Exception => {
        e.printStackTrace()
        logger.error("Properties file " + name + " is failed to load, exception: " + e.getMessage)
      }
    }
    props
  }

  def getString(props: Properties, name: String): String = {
    getString(props, name, null)
  }

  def getString(props: Properties, name: String, defaultValue: String): String = {
    if (props != null && props.contains(name)) {
      props.getProperty(name, defaultValue)
    } else null
  }

}
