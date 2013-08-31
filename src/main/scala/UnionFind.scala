/**
 * Created with IntelliJ IDEA.
 */
object UnionFind extends App {

  val a = Array[Int](0,1,2,3,4,5,6,7,8,9)

  for ( i <- a) {
    println(i)
  }

  val unionFind = new UnionFind()
  unionFind.union(1, 2)

}

class UnionFind {

  def union(a:Int, b:Int):Unit = {
    Console.println("union of " + a + "+" + b)
  }

}
