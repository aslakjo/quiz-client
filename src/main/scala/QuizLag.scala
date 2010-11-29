package main.scala

import se.scalablesolutions.akka.actor._
import se.scalablesolutions.akka.remote._
import se.scalablesolutions.akka.actor.Actor

import no.bekk.scala.messages._
import no.bekk.scala.Team

class QuizLag(val host:String, val navn: String)
{
  val team = new Team(navn)
  val remote = RemoteClient.actorFor("Server", host, 9999)

  (1 until 40).foreach(_=>{
    (remote !! MoreChallenges(team)) match
    {
      case Some(question:Question) => answer(question)
      case None => println("Ingen melding"); null
    }
  })

  def answer(question:Question):Answer ={
    new Answer(team, question, "pong")  
  }
}

object QuizLag  
{
  def main(args: Array[String]): Unit = {
    new QuizLag(args(0), args(1))
  }

}