package test

import akka.actor.ActorSystem
import kamon.Kamon

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object Main extends App {
  Kamon.start()
  val as = ActorSystem("my-test-system")
  import as.dispatcher

  for (i <- 0 until 1000) {
    Future {
      println(s"Counter ${i}")

      Thread.sleep(500)
    }
  }

  Thread.sleep(30000)

  Await.ready(as.terminate(), 5.seconds)
  Kamon.shutdown()
}
