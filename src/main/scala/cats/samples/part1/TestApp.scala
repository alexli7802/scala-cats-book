package cats.samples.part1


object TestApp {
  
  def string2Json_1(): Unit = {
    import JsonWriters._
    
    val s = "hello type class"
    val sj = Json.toJson(s)
    println(sj.asInstanceOf[JsString].get)
  }
  
  def string2Json_2(): Unit = {
    import JsonSyntax._
    import JsonWriters._
    
    val s = "hello json syntax"
    val sj = s.toJson
    println(sj.asInstanceOf[JsString].get)
  }
  
  /*
   *  main entry-point
   */
  def main(args: Array[String]): Unit = {
    string2Json_2()
  }
}