package cats.samples.part1

trait Printable[A] {
  def format(a: A): String
}

/*
 * Use companion object to provide user-APIs
 */
object Printable {
  
  def format[A](a: A)(implicit p: Printable[A]): String = p.format(a)
  
  def print[A](a: A)(implicit p: Printable[A]): Unit = println(p.format(a))
}

/*
 * Use extension methods to provide user-APIs
 */
object PrintableSyntax {
  implicit class PrintableOps[A](a: A) {
    def format(implicit p: Printable[A]): String = p.format(a)
    def print(implicit p: Printable[A]): Unit = println(p.format(a))
  }
}