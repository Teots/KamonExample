import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.archetypes.scripts.BashStartScriptPlugin
import sbt.Keys._
import sbt._

name := "kamon-akka-example"

version := "1.0"

scalaVersion := "2.11.11"

enablePlugins(BashStartScriptPlugin, JavaAppPackaging, SbtAspectj)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.6",
  "io.kamon" %% "kamon-core" % "0.6.7",
  "io.kamon" %% "kamon-akka-2.5" % "0.6.8",
  "io.kamon" %% "kamon-log-reporter" % "0.6.8",
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)

fork in run := true
javaOptions in run ++= (aspectjWeaverOptions in Aspectj).value
