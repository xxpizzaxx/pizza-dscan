name := "pizza-dscan"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "com.sparkjava" % "spark-core" % "2.3"
libraryDependencies += "moe.pizza" %% "eveapi" % "0.22"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

enablePlugins(SbtTwirl)
