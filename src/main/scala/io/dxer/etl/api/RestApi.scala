package io.dxer.etl.api

import java.util.{HashMap => JHashMap, Map => JMap}

import com.google.common.base.Strings
import io.dxer.etl.{SQLEngine, SparkSessionHolder}
import javax.ws.rs._
import javax.ws.rs.core.MediaType

@Path("/")
class RestApi {


  @GET
  @Path("/hello/{name}")
  @Produces(Array(MediaType.TEXT_PLAIN))
  def sayHello(@PathParam("name") name: String): String = {
    return "hello, " + name
  }

  @POST
  @Path("/execute")
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @Produces(Array(MediaType.APPLICATION_JSON))
  def execute(request: Request): JMap[String, Any] = {
    val resultMap = new JHashMap[String, Any]()

    if (!Strings.isNullOrEmpty(request.getSql)) {
      val result = SQLEngine.execute(SparkSessionHolder.sparkSession, request.getSql)
      resultMap.put("msg", result.message)
      resultMap.put("cost", result.getCost())
    }

    resultMap
  }
}
