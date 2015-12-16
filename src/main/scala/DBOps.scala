import slick.jdbc.JdbcBackend
import slick.driver.MySQLDriver.api._
import moe.pizza.sdeapi._
import scala.concurrent.duration._

/**
 * Created by Andi on 16/12/2015.
 */
class DBOps(db: JdbcBackend.Database) {

  def getTypeGroups(): Unit = {
    Tables.Invtypes.join(Tables.Invgroups)
  }

  val groupsQuery = for {
    ((t, g), c) <- Tables.Invtypes join Tables.Invgroups on (_.groupid === _.groupid) join Tables.Invcategories on (_._2.categoryid === _.categoryid)
  } yield (t.typename, t.typeid, g.groupname, c.categoryname)

  lazy val groups = groupsQuery.result.run(db).sync(60 seconds)

}
