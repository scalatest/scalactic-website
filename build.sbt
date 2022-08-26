lazy val root = (project in file(".")).settings(
  name := "scalactic",
  version := "scalactic-220826-ecr",
  scalaVersion := "2.13.5",
  libraryDependencies ++= Seq(
    "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3"
  ),
  fork := false, 
  Docker / packageName := "artima/scalactic-website", 
  Docker / maintainer := "Artima Inc.", 
  dockerExposedPorts ++= Seq(9000), 
  dockerUpdateLatest := true, 
  Universal / javaOptions ++= Seq(
    // -J params will be added as jvm parameters
    "-J-Xmx256m",
    "-J-Xms128m"
  )
  //classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.Flat  // Added in sbt 1.3 (https://www.scala-sbt.org/1.x/docs/sbt-1.3-Release-Notes.html), but still not working, so we fall back to sbt 1.2.
).enablePlugins(PlayScala, JavaServerAppPackaging, DockerPlugin)
