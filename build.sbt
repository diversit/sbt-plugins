lazy val commonSettings = Seq(
  organization := "eu.diversit.sbt.plugins",
  scalaVersion := "2.10.6",
  sbtPlugin := true
)

lazy val cspPlugin = (project in file("create-source-folders-plugin")).
  settings(
    commonSettings
  )
