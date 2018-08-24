package io.dxer.etl

import com.sun.jersey.spi.container.servlet.ServletContainer
import org.apache.spark.internal.Logging
import org.spark_project.jetty.server.Server
import org.spark_project.jetty.servlet.{ServletContextHandler, ServletHolder}

class HttpServer extends Logging {

  def start(port: Int = 8090): Unit = {
    val server = new Server(port)
    val context = new ServletContextHandler(ServletContextHandler.SESSIONS)
    context.setContextPath("/")
    server.setHandler(context)
    val holder = new ServletHolder(classOf[ServletContainer])
    holder.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig")
    holder.setInitParameter("com.sun.jersey.config.property.packages", "io.dxer.etl.api")

    context.addServlet(holder, "/*")
    server.start()
    log.info(s"HttpServer is started on port ${port}")
  }
}
