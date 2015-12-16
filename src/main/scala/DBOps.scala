import slick.jdbc.JdbcBackend
import slick.driver.MySQLDriver.api._
import moe.pizza.sdeapi._
import scala.concurrent.duration._

/**
 * Created by Andi on 16/12/2015.
 */
class DBOps(db: JdbcBackend.Database) {

  val groupsQuery = for {
    ((t, g), c) <- Tables.Invtypes join Tables.Invgroups on (_.groupid === _.groupid) join Tables.Invcategories on (_._2.categoryid === _.categoryid)
  } yield (t.typename, t.typeid, g.groupname, c.categoryname)

  case class GroupData(typeId: Int, typeName: String, groupName: Option[String], categoryName: Option[String])
  lazy val groups = groupsQuery.result.run(db).sync(60 seconds).filter(_._1.nonEmpty).map(t => GroupData(t._2, t._1.get, t._3, t._4)).map(gd => (gd.typeName, gd)).toMap
}
