/**
 *
 * Created by Andi on 15/12/2015.
 */
import spark._
import spark.Spark._
import SparkWebScalaHelpers._

object HelloWorld extends App {
  get("/hello", (req: Request, resp: Response) => req.ip())
  get("/name", (req: Request, resp: Response) => templates.html.hello.render("Bob"))
}
