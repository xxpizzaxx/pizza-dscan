/**
 *
 * Created by Andi on 15/12/2015.
 */
import spark._
import spark.Spark._
import SparkWebScalaHelpers._
import slick.jdbc.JdbcBackend._

import scala.io.Source

object DScanWebapp extends App {
  lazy val db = new DBOps(Database.forURL("jdbc:mysql://localhost:3306/sde", "sde", "sde", driver = "com.mysql.jdbc.Driver"))
  staticFileLocation("/static")
  post("/", (req: Request, resp: Response) => {
    "foo"
  })
  get("/test", (req: Request, resp: Response) => {
    val data = Source.fromURL(getClass.getResource("/wormhole.txt")).getLines().mkString("\n")
    val d = DScan.create(data)
    templates.html.base.apply("results", templates.html.results.apply(d, "test system", db).toString())
  })
}
