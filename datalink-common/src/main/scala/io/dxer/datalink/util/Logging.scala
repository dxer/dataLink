package io.dxer.datalink.util

import org.slf4j.{LoggerFactory, Logger => Slf4jLogger}

import scala.reflect.ClassTag


trait Logging {
  protected[this] lazy val logger = {
    val n = getClass.getName
    val cln = if (n endsWith "$") n.substring(0, n.length - 1) else n
    new DataLinkLogger(LoggerFactory.getLogger(cln))
  }
}

final class DataLinkLogger(val slf4jLogger: Slf4jLogger) {

  @inline
  def isDebugEnabled = slf4jLogger.isDebugEnabled()

  @inline
  def error(msg: => String) {
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(msg)
  }

  @inline
  def error(msg: => String, t: Throwable) {
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(msg, t)
  }

  @inline
  def warn(msg: => String) {
    if (slf4jLogger.isWarnEnabled) slf4jLogger.warn(msg)
  }

  @inline
  def warn(msg: => String, t: Throwable) {
    if (slf4jLogger.isWarnEnabled) slf4jLogger.warn(msg, t)
  }

  @inline
  def info(msg: => String) {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.info(msg)
  }

  @inline
  def info(msg: => String, t: Throwable) {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.info(msg, t)
  }

  @inline
  def debug(msg: => String) {
    if (slf4jLogger.isDebugEnabled) slf4jLogger.debug(msg)
  }

  @inline
  def debug(msg: => String, t: Throwable) {
    if (slf4jLogger.isDebugEnabled) slf4jLogger.debug(msg, t)
  }

  @inline
  def trace(msg: => String) {
    if (slf4jLogger.isTraceEnabled) slf4jLogger.trace(msg)
  }

  @inline
  def trace(msg: => String, t: Throwable) {
    if (slf4jLogger.isTraceEnabled) slf4jLogger.trace(msg, t)
  }
}


object DataLinkLogger {
  //  private val treePrinter =
  //    new TreePrinter(prefix = DumpInfo.highlight(if (GlobalConfig.unicodeDump) "\u2503 " else "| "))

  def apply[T](implicit ct: ClassTag[T]): DataLinkLogger = {
    new DataLinkLogger(LoggerFactory.getLogger(ct.runtimeClass))
  }
}


