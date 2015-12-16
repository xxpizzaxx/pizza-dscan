/**
 *
 * Created by Andi on 15/12/2015.
 */
import spark._
import spark.Spark._
import SparkWebScalaHelpers._
import slick.jdbc.JdbcBackend._

object DScanWebapp extends App {
  lazy val db = new DBOps(Database.forURL("jdbc:mysql://localhost:3306/sde", "sde", "sde", driver = "com.mysql.jdbc.Driver"))
  staticFileLocation("/static")
  post("/", (req: Request, resp: Response) => {
    "foo"
  })
}
