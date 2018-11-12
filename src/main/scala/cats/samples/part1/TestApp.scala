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
  
  def opts2Json(): Unit = {
    import JsonWriters._

    Json.toJson(Option("cats"))    // A = Option[String]
                                   // ?: JsonWriter[Option[String]]   No but, JsonWriter[Option[A]]
  }
  
  
  def printableTesting(): Unit = {
    import PrintableInstances._
    Printable.print( 4 + 2 )
    Printable.print( "hello" + " cats")
  }
  
  def print2(): Unit = {
    final case class Cat(name: String, age: Int, color: String)

    import PrintableSyntax._
    import PrintableInstances._
    
    Cat("Meow", 2, "teal").print
    
  }
  /*
   *  main entry-point
   */
  def main(args: Array[String]): Unit = {
    printableTesting()
  }
}