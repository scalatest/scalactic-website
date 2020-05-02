lazy val root = (project in file(".")).settings(
  name := "scalactic",
  version := "200502",
  scalaVersion := "2.13.1",
  libraryDependencies ++= Seq(
    "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3"
  ),
  fork := false, 
  packageName in Docker := "artima/scalactic-website", 
  maintainer in Docker := "Artima Inc.", 
  dockerExposedPorts ++= Seq(9000), 
  dockerUpdateLatest := true
  //classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.Flat  // Added in sbt 1.3 (https://www.scala-sbt.org/1.x/docs/sbt-1.3-Release-Notes.html), but still not working, so we fall back to sbt 1.2.
).enablePlugins(PlayScala, JavaServerAppPackaging, DockerPlugin)
