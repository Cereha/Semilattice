import scala.language.implicitConversions

trait Semilattice[A] {
  def intersection(x: A, y: A): A
}

object Semilattice{
  implicit val intSemilattice = new Semilattice[Set[Int]] {
    override def intersection(x: Set[Int], y: Set[Int]):
    Set[Int] = x & y
  }
}

class SemilatticeOps[A: Semilattice](x: A)(implicit g: Semilattice[A]){
  def &&(y: A): A = g.intersection(x, y)
}

object L1 {
  def main(args: Array[String]): Unit = {
    implicit def sg[A](x: A)(implicit g: Semilattice[A]): SemilatticeOps[A] = {
      new SemilatticeOps[A](x)
    }
  
  }
}