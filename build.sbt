lazy val root = (project in file(".")).settings(
  name := "scalactic",
  version := "scalactic-220124-ecr",
  scalaVersion := "2.13.5",
  libraryDependencies ++= Seq(
    "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3"
  ),
  fork := false, 
  packageName in Docker := "artima/scalactic-website", 
  maintainer in Docker := "Artima Inc.", 
  dockerExposedPorts ++= Seq(9000), 
  dockerUpdateLatest := true, 
  javaOptions in Universal ++= Seq(
    // -J params will be added as jvm parameters
    "-J-Xmx256m",
    "-J-Xms128m"
  )
  //classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.Flat  // Added in sbt 1.3 (https://www.scala-sbt.org/1.x/docs/sbt-1.3-Release-Notes.html), but still not working, so we fall back to sbt 1.2.
).enablePlugins(PlayScala, JavaServerAppPackaging, DockerPlugin)
