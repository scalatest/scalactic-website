lazy val root = (project in file(".")).settings(
  name := "scalactic",
  version := "scalactic-231111-ecr",
  scalaVersion := "2.13.12",
  libraryDependencies ++= Seq(
    guice,
    "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test
  ),
  fork := false, 
  Docker / packageName := "artima/scalactic-website", 
  Docker / maintainer := "Artima Inc.", 
  dockerExposedPorts ++= Seq(9000), 
  dockerUpdateLatest := true,
  dockerBaseImage := "eclipse-temurin:17",
  Universal / javaOptions ++= Seq(
    // -J params will be added as jvm parameters
    "-J-Xmx128m",
    "-J-Xms64m"
  )
  //classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.Flat  // Added in sbt 1.3 (https://www.scala-sbt.org/1.x/docs/sbt-1.3-Release-Notes.html), but still not working, so we fall back to sbt 1.2.
).enablePlugins(PlayScala, JavaServerAppPackaging, DockerPlugin)
