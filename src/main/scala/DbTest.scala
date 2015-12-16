import slick.jdbc.JdbcBackend._

/**
 * Created by Andi on 16/12/2015.
 */
object DbTest extends App {
  lazy val db = new DBOps(Database.forURL("jdbc:mysql://localhost:3306/sde", "sde", "sde", driver = "com.mysql.jdbc.Driver"))
  println(db.groups)
}
