name := """play-scala-slick-example"""
organization := "com.rinotc"

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  guice,
  "com.typesafe.play" %% "play-slick" % "3.0.3",
  "org.mariadb.jdbc" % "mariadb-java-client" % "2.2.1",
  "com.zaxxer" % "HikariCP" % "2.7.4",
  "com.danielasfregola" %% "twitter4s" % "6.2",
  specs2 % Test,
)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings"
)
