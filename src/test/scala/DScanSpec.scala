import org.scalatest.FlatSpec


import scala.io.Source
import slick.jdbc.JdbcBackend._

/**
 * Created by Andi on 16/12/2015.
 */
class DScanSpec extends FlatSpec {

  "the example wormhole scan" should "parse cleanly" in {
    val data = Source.fromURL(getClass.getResource("/wormhole.txt")).getLines().mkString("\n")
    val d = DScan.create(data)

  }



}
