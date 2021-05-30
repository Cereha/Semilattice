import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Gen, Prop}
import SemilatticeOps._

object SemilatticeSpesification extends Properties("Semilattice"){
  property ("associativity") = forAll { 
      (a: Set[Int], b: Set[Int], c: Set[Int]) =>
      var s1 : Set[Int] = (a && b) && c
      var s2 : Set[Int] = a && (b && c)
      s1 == s2      
    }
  property ("commutativity") = forAll{
      (a: Set[Int], b: Set[Int]) =>
      var s1 : Set[Int] = a && b
      var s2 : Set[Int] = b && a
      s1 == s2 
    }
  property ("idenpotency") = forAll{
      (a: Set[Int]) =>
      var s1 : Set[Int] = a && a
      s1 == a
    }
}