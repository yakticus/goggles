crossScalaVersions := Seq("2.11.6")

lazy val goggles = crossProject
  .settings(
    organization := "com.yakticus",
    name := "goggles",
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.11.6",
    autoCompilerPlugins := true,
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "scalarx" % "0.2.8",
      "com.lihaoyi" %%% "upickle" % "0.3.0"
    ),
    licenses := Seq("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    homepage := Some(url("https://github.com/yakticus/goggles")),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },
    pomExtra := (
      <scm>
        <url>git@github.com:yakticus/goggles.git</url>
        <connection>scm:git:git@github.com:yakticus/goggles.git</connection>
      </scm>
        <developers>
          <developer>
            <id>yakticus</id>
            <name>Julie Pitt</name>
            <url>https://github.com/yakticus</url>
          </developer>
        </developers>)
  )
  .jvmSettings()
  .jsSettings(
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.8.0"
    )
  )

lazy val jvm = goggles.jvm
lazy val js = goggles.js
