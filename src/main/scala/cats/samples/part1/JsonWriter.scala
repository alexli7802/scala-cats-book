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

  implicit val intWriter: JsonWriter[Int] = 
    new JsonWriter[Int] {
      def write(value: Int): Json = JsNumber(value)
    }
  
  implicit val stringWriter: JsonWriter[String] = 
    new JsonWriter[String] {
      def write(value: String): Json = JsString(value)
    }
  
  implicit def optionWriter[A](implicit w: JsonWriter[A]): JsonWriter[Option[A]] = 
    new JsonWriter[Option[A]] {
      def write(value: Option[A]): Json = value match {
        case Some(aValue) => w.write(aValue)
        case None => JsNull
      }
    }
  
}