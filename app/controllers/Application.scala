/**
 * Copyright 2010-2013 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package controllers

import play.api._
import play.api.mvc._
import javax.inject.Inject

class Application @Inject() (cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index())
  }

  def install = Action {
    Ok(views.html.install())
  }

  def download = Action {
    Redirect(routes.Application.install.url)
  }

  def olderReleases = Action {
    Ok(views.html.olderReleases())
  }

  def quickStart = Action {
    Ok(views.html.quickStart())
  }

  def scaladoc = Action {
    Ok(views.html.scaladoc())
  }

  def community = Action {
    Redirect(routes.Application.about.url)
  }

  def supersafe = Action {
    Ok(views.html.supersafe())
  }

  def about = Action {
    Ok(views.html.about())
  }
}

object Application {

  val latestVersion = "3.2.18"
  val latestSuperSafeVersion = "1.1.12"
  val milestoneVersion = "3.1.0-RC3"
  val milestoneJar = "https://oss.sonatype.org/content/groups/public/org/scalactic/scalactic_2.13/3.1.0-RC3/scalactic_2.10-3.1.0-RC3.jar"
  val latestJar = s"https://oss.sonatype.org/content/groups/public/org/scalactic/scalactic_2.13/$latestVersion/scalactic_2.13-$latestVersion.jar"
  val milestoneScaladoc = "http://www.artima.com/docs-scalatest-3.1.0-RC3"
  val scaladocsLocation = "http://doc.scalatest.org"
  val releasesLocation = "http://www.artima.com/downloadScalaTest"
  val baseScalaVersion = "2.13.12"
  val majorMinorScalaVersion = "2.13"

  def scaladocsPageUrl(file: String, version: String = latestVersion): String = {
    val oldScaladocStyle30Releases = List("3.0.0", "3.0.1", "3.0.2", "3.0.3", "3.0.4")
    val filePath =
      if (version.startsWith("1.") || version.startsWith("2.") || oldScaladocStyle30Releases.contains(version)) {
        s"$version/index.html#$file"
      }
      else s"$version/${file.replaceAll("\\.", "/")}.html"

    routes.Assets.at("/public/scaladoc", filePath).toString
  }

  def scalatestScaladocsPageUrl(file: String, version: String = latestVersion): String = {
    val oldScaladocStyle30Releases = List("3.0.0", "3.0.1", "3.0.2", "3.0.3", "3.0.4")
    val filePath =
      if (version.startsWith("1.") || version.startsWith("2.") || oldScaladocStyle30Releases.contains(version)) {
        s"$version/index.html#$file"
      }
      else s"$version/${file.replaceAll("\\.", "/")}.html"

    s"https://www.scalatest.org/scaladoc/$filePath"
  }
}
