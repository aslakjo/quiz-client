package test.scala
import org.scalatest.{FlatSpec, BeforeAndAfterEach}
import org.scalatest.matchers.ShouldMatchers
import no.bekk.scala.messages.Question
import scala.xml.NodeSeq

import no.bekk.scala._
import main.scala.QuizLag

class QuizLagTests  extends FlatSpec with ShouldMatchers with BeforeAndAfterEach {
    "Runing the client" should "comunicate with the server" in {
      new QuizLag("127.0.0.1", "aslak!")
    }
}