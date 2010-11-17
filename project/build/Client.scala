import sbt._

class Client(info: ProjectInfo) extends DefaultProject(info) with AkkaProject {
  override def mainClass = Some("QuizLag")
   
}