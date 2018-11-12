package cats.samples.part1

/*
 *  A simple type class: trait, type parameter, abstract methods
 */

trait JsonWriter[A] {
  
  def write(value: A): Json
}

/*
 * implicit instances of type class
 */
object JsonWriters {
  
  implicit val stringWriter: JsonWriter[String] = 
    new JsonWriter[String] {
      def write(value: String): Json = JsString(value)
    }
}