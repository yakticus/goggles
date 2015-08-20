import com.lihaoyi.workbench.Plugin._

lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "goggles"
normalizedName := "goggles"
version := "0.1-SNAPSHOT"
organization := "com.yakticus"
crossScalaVersions := Seq("2.10.5", "2.11.6")
scalacOptions ++= Seq("-deprecation", "-feature")
homepage := Some(url("https://github.com/yakticus/goggles"))
licenses += ("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
scmInfo := Some(ScmInfo(
  url("https://github.com/yakticus/goggles"),
  "scm:git:git@github.com:yakticus/goggles.git",
  Some("scm:git:git@github.com:yakticus/goggles.git")))
publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false }
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
    <developers>
      <developer>
        <id>yakticus</id>
        <name>Julie Pitt</name>
        <url>https://github.com/yakticus</url>
      </developer>
    </developers>
  )

libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "scalarx" % "0.2.8",
  "com.lihaoyi" %%% "scalatags" % "0.5.2",
  "com.lihaoyi" %%% "upickle" % "0.3.5"
)

lazy val examples = project.in(file("examples"))
  .dependsOn(root)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    workbenchSettings,
    scalaVersion := "2.11.6",
    resolvers += Resolver.sonatypeRepo("snapshots"),
    bootSnippet := "example.d3.ForceDirectedGraph().main(document.getElementById('container'));"
  )
