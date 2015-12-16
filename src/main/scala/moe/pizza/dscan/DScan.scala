package moe.pizza.dscan

/**
 * Created by Andi on 16/12/2015.
 */
object DScan {
  def create(input: String): DScan = {
    new DScan(input.split("\n").map(_.split("\t")).filter(_.length == 3).map(l => DScanLine(l(0), l(1), l(2))).toList)
  }

}
case class DScanLine(name: String, typeName: String, distance: String)

case class DScan(contents: List[DScanLine]) {
  def createBreakdown(db: DBOps): Map[db.GroupData, Int] = {
    val counts = contents.groupBy(_.typeName).mapValues(_.length)
    counts.map(kv => (db.groups(kv._1), kv._2))
  }
}
