crossScalaVersions := Seq("2.11.6")

lazy val goggles = crossProject
  .settings(
    organization := "com.yakticus",
    name := "goggles",
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.11.6",
    autoCompilerPlugins := true
  )//.jvmSettings().jsSettings()

lazy val jvm = goggles.jvm
lazy val js = goggles.js
