/**
 *
 * Created by Andi on 15/12/2015.
 */
import spark._
import spark.Spark._
import SparkWebScalaHelpers._

object DScanWebapp extends App {
  staticFileLocation("/static")
  post("/", (req: Request, resp: Response) => {
    "foo"
  })
}
