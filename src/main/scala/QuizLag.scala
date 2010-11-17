package main.scala

import se.scalablesolutions.akka.actor._
import se.scalablesolutions.akka.remote._
import se.scalablesolutions.akka.actor.Actor

import no.bekk.scala.messages._
import no.bekk.scala.Team

class QuizLag(val host:String)
{
  val team = new Team("Aslak!")
  val remote = RemoteClient.actorFor("Server", host, 9999)

  val question = (remote !! MoreChallenges(team)) match
  {
    case Some(q:Question) => q
    case None => println("fail"); null
  }
  
  (1 until 20).foreach( _ =>  println(remote !! new Answer(team, question, "pong")))
}

object QuizLag  
{
  def main(args: Array[String]): Unit = {
    new QuizLag(args(0))
  }

}