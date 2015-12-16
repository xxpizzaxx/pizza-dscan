/**
 * Created by Andi on 16/12/2015.
 */
object DScan {
  case class DScanLine(name: String, typeName: String, distance: String)
  def create(input: String): Unit = {
    val counts = input
      .split("\n")
      .map(_.split("\t"))
      .filter(_.length == 3)
      .map(l => DScanLine(l(0), l(1), l(2)))
      .groupBy(_.typeName)
      .mapValues(_.length)
    println(counts)
  }

}
