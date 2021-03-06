/**
 * Created with IntelliJ IDEA.
 */
object UnionFind extends App {

  var a:Array[Int] = _
  var sz:Array[Int] = _

  def union(p:Int, q:Int):Unit = {

    val pid = a(p)
    val qid = a(q)

    var pos = 0
    for ( i <- a) {
      if (i == pid) {
        a.update(pos, qid)
      }
      pos += 1
    }

    for ( i <- a) {
      print(i + " ")
    }

    print ("   (array)\n")

  }


  //function implementation of root
  def root(x:Int):Int = {
    if (x == a(x))
      return x
    else
      root(a(x))
  }

  def unionWeighted(p:Int, q:Int):Unit = {

    val pid = root(p)
    val qid = root(q)

    if (sz(pid) < sz(qid)) {
      a.update(pid, qid)
      sz.update(qid, sz(qid) + sz(pid))
    } else {
      a.update(qid, pid)
      sz.update(pid, sz(pid) + sz(qid))
    }


    for ( i <- a) {
      print(i + " ")
    }

    print ("   (array)\n")

    for ( j <- sz) {
      print(j + " ")
    }

    print ("    (size)\n")

  }


  override def main(args:Array[String]) = {
    a = Array[Int](0,1,2,3,4,5,6,7,8,9)
    sz = Array.fill(10)(1)
    unionWeighted(7,1)
    unionWeighted(5,0)
    unionWeighted(2,4)
    unionWeighted(0,8)
    unionWeighted(3,5)
    unionWeighted(2,1)
    unionWeighted(6,0)
    unionWeighted(5,9)
    unionWeighted(7,5)
  }

}

class UnionFind {

  def union(a:Int, b:Int):Unit = {
    Console.println("union of " + a + "+" + b)
  }

}
