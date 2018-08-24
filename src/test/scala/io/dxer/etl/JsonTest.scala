package io.dxer.etl

import com.google.common.base.Strings
import com.google.common.collect.Maps
import com.google.gson.Gson

case class TT(var name: String, var age: Int)

object JsonTest {

  def main(args: Array[String]): Unit = {
    println("select * from tttt;\r\nselect* from tt")
    var t = new TT("1", 1)
    val gson = new Gson()
    val s = gson.toJson(t)
    println(s)
    println(gson.fromJson(s, classOf[TT]))

    val map = Maps.newHashMap[String, String]()
    map.put("1", "1")
    map.put("2", "2")

    val ss = gson.toJson(map)
    println(ss)
    println(gson.fromJson(ss, classOf[java.util.HashMap[String, String]]))


    val resultMap = scala.collection.mutable.Map[String, Any]()

    resultMap += ("msg" -> "test")


    println(gson.toJson(resultMap))
  }
}
