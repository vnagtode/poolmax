//import AssemblyKeys._
//import sbt._
//import Keys._
import Process._
//import sbtassembly.AssemblyPlugin.autoImport._

val project_version = "0.1.0-SNAPSHOT"

val SCALAVERSION = "2.12.3"

lazy val root = (project in file("."))
  .settings(
    name := "scala"
    ,organization := "com.poolmax"
    ,scalaVersion := SCALAVERSION
    ,version := project_version
    ,libraryDependencies += mapsServ
  )

val mapsServ = "com.google.maps" % "google-maps-services" % "0.2.11"

lazy val sharedSettings = Seq(

  libraryDependencies ++= Seq(
    "com.google.maps" % "google-maps-services" % "0.2.11",
    "org.slf4j" % "slf4j-nop" % "2.2"
  )
)