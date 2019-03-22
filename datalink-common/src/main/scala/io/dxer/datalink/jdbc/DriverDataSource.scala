package io.dxer.datalink.jdbc

import java.io.{Closeable, PrintWriter}
import java.sql._
import java.util.Properties
import java.util.logging.Logger

import io.dxer.datalink.exception.DataLinkException
import io.dxer.datalink.util.{Logging, Utils}
import javax.sql.DataSource

import scala.beans.BeanProperty
import scala.util.control.NonFatal
import scala.collection.JavaConverters._


class DriverDataSource(
                        /** The JDBC URL (required) */
                        @BeanProperty @volatile var url: String,

                        /** Name of the `java.sql.Driver` class. This must be set unless a `driverObject` is set
                          * directly or the driver is already registered with the DriverManager. */
                        @BeanProperty @volatile var driverClassName: String = null,

                        /** Optional user name */
                        @BeanProperty @volatile var user: String = null,

                        /** Optional password */
                        @BeanProperty @volatile var password: String = null,

                        /** Optional connection properties */
                        @BeanProperty @volatile var properties: Properties = null,


                        /** When `close()` is called, try to deregister a driver that was registered by this instance. */
                        @BeanProperty @volatile var deregisterDriver: Boolean = false,

                        /** The JDBC driver to use. If this is set, `driverClassName` will be ignored. */
                        @volatile var driverObject: Driver = null,

                        /** The ClassLoader that is used to load `driverClassName` */
                        @volatile var classLoader: ClassLoader = Utils.defaultClassLoader
                      ) extends DataSource with Closeable with Logging {
  def this() = this(null)


  // State that gets initialized by `init`
  @volatile private[this] var registered: Boolean = false
  @volatile private[this] var initialized = false
  @volatile private[this] var driver: Driver = _
  @volatile private[this] var connectionProps: Properties = _

  def init: Unit = if (!initialized) {
    this.synchronized {
      if (!initialized) {
        try {
          if (url eq null) throw new SQLException("Required parameter \"url\" missing in DriverDataSource")
          driver = if (driverObject eq null) {
            if (driverClassName ne null) {
              DriverManager.getDrivers.asScala.find(_.getClass.getName == driverClassName).getOrElse {
                logger.debug(s"Driver $driverClassName not already registered; trying to load it")
                val cl = classLoader.loadClass(driverClassName)
                registered = true
                DriverManager.getDrivers.asScala.find(_.getClass.getName == driverClassName).getOrElse {
                  logger.debug(s"Loaded driver $driverClassName but it did not register with DriverManager; trying to instantiate directly")
                  try cl.newInstance.asInstanceOf[Driver] catch {
                    case ex: Exception =>
                      logger.debug(s"Instantiating driver class $driverClassName failed; asking DriverManager to handle URL $url", ex)
                      try DriverManager.getDriver(url) catch {
                        case ex: Exception =>
                          throw new DataLinkException(s"Driver $driverClassName does not know how to handle URL $url", ex)
                      }
                  }
                }
              }
            } else try DriverManager.getDriver(url) catch {
              case ex: Exception =>
                throw new DataLinkException(s"No driver specified and DriverManager does not know how to handle URL $url", ex)
            }
          } else driverObject
          if (!driver.acceptsURL(url)) {
            close()
            throw new DataLinkException(s"Driver ${driver.getClass.getName} does not know how to handle URL $url")
          }
          connectionProps = propsWithUserAndPassword(properties, user, password)
        } catch {
          case e: Exception => e.printStackTrace()
          case NonFatal(ex) =>
            close()
        } finally initialized = true
      }
    }
  }

  private[this] def propsWithUserAndPassword(p: Properties, user: String, password: String): Properties = {
    if ((p ne null) && (user eq null) && (password eq null)) p else {
      val p2 = new Properties(p)
      if (user ne null) p2.setProperty("user", user)
      if (password ne null) p2.setProperty("password", password)
      p2
    }
  }

  def getConnection: Connection = {
    init
    driver.connect(url, connectionProps)
  }

  def getConnection(username: String, password: String): Connection = {
    init
    driver.connect(url, propsWithUserAndPassword(connectionProps, username, password))
  }

  def close(): Unit = if (registered && deregisterDriver && (driver ne null)) {
    DriverManager.deregisterDriver(driver)
    registered = false
  }

  def getLoginTimeout: Int = DriverManager.getLoginTimeout

  def setLoginTimeout(seconds: Int): Unit = DriverManager.setLoginTimeout(seconds)

  def getLogWriter: PrintWriter = throw new SQLFeatureNotSupportedException()

  def setLogWriter(out: PrintWriter): Unit = throw new SQLFeatureNotSupportedException()

  def getParentLogger: Logger = {
    init
    try driver.asInstanceOf[ {def getParentLogger(): Logger}].getParentLogger
    catch {
      case _: NoSuchMethodException => throw new SQLFeatureNotSupportedException()
    }
  }

  def isWrapperFor(iface: Class[_]): Boolean = iface.isInstance(this)

  def unwrap[T](iface: Class[T]): T =
    if (iface.isInstance(this)) this.asInstanceOf[T]
    else throw new SQLException(getClass.getName + " is not a wrapper for " + iface)

}
