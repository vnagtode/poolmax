//import AssemblyKeys._
//import sbt._
import Keys._
//import Process._


//ThisBuild / version      :=  "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.6"
//ThisBuild / organization := "com.poolmax"
crossScalaVersions := Seq("2.11.12", "2.12.6")

lazy val GatlingTest = config("gatling") extend Test

def gatlingVersion(scalaBinVer: String): String = scalaBinVer match {
  case "2.11" => "2.2.5"
  case "2.12" => "2.3.1"
}

libraryDependencies += guice
libraryDependencies += "org.joda" % "joda-convert" % "2.1.2"
libraryDependencies += "net.logstash.logback" % "logstash-logback-encoder" % "4.11"

libraryDependencies += "com.netaporter" %% "scala-uri" % "0.4.16"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.2.1"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion(scalaBinaryVersion.value) % Test
libraryDependencies += "io.gatling" % "gatling-test-framework" % gatlingVersion(scalaBinaryVersion.value) % Test

libraryDependencies += "com.google.maps" % "google-maps-services" % "0.2.11"
libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.25" % Test

libraryDependencies += "joda-time" % "joda-time" % "2.10.1"


// The Play project itself
lazy val root = (project in file("."))
  .enablePlugins(Common, PlayScala, GatlingPlugin)
  .configs(GatlingTest)
  .settings(inConfig(GatlingTest)(Defaults.testSettings): _*)
  .aggregate(navigator)
  .dependsOn(navigator)
  .settings(
    name := """poolmax-core""",
    scalaSource in GatlingTest := baseDirectory.value / "/gatling/simulation"
  )

/*
lazy val root = (project in file("."))
  .aggregate(navigator)
  .settings(
    name := "scala",
    //libraryDependencies ++= Seq(mapsServ, slf4j)
    //libraryDependencies += "joda-time" % "joda-time" % "2.10.1"
    //ThisBuild / libraryDependencies
  )
*/


lazy val navigator = (project in file("navigator"))
  .enablePlugins(Common, PlayScala, GatlingPlugin)
  .configs(GatlingTest)
  .settings(inConfig(GatlingTest)(Defaults.testSettings): _*)
  .settings(
    name := "navigator",
    //libraryDependencies ++= Seq(mapsServ, slf4j)
    //libraryDependencies += "joda-time" % "joda-time" % "2.10.1",
    //libraryDependencies += "com.google.maps" % "google-maps-services" % "0.2.11"
  )


// Documentation for this project:
//    sbt "project docs" "~ paradox"
//    open docs/target/paradox/site/index.html
lazy val docs = (project in file("docs")).enablePlugins(ParadoxPlugin).
  settings(
    paradoxProperties += ("download_url" -> "https://example.lightbend.com/v1/download/play-rest-api")
  )