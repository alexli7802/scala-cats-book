package cats.samples.part1

/*
 *  A very simple AST
 */

sealed trait Json

final case class JsObject(get: Map[String,Json]) extends Json
final case class JsString(get: String) extends Json
final case class JsNumber(get: Double) extends Json
case object JsNull extends Json


object Json {
  
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)

}

object JsonSyntax {
  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit w: JsonWriter[A]): Json = w.write(value)
  }
}