/**
 * Created by Andi on 16/12/2015.
 */
case class DScanLine(name: String, typeName: String, distance: String)

object DScan {
  def create(input: String): DScan = {
    new DScan(input.split("\n").map(_.split("\t")).filter(_.length == 3).map(l => DScanLine(l(0), l(1), l(2))).toList)
  }

}
case class DScan(contents: List[DScanLine]) {
  def createBreakdown(): Map[String, Int] = {
    contents.groupBy(_.typeName).mapValues(_.length)
  }
}
