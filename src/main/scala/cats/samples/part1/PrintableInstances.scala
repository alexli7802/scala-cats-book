package cats.samples.part1

object PrintableInstances {
  
  implicit val printableInt: Printable[Int] = 
    new Printable[Int] {
      def format(i: Int): String = i.toString
    }

  implicit val printableString: Printable[String] = 
    new Printable[String] {
      def format(s: String): String = s
    }
}