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

object Application extends Controller {

  val latestScaladoc = "http://doc.scalatest.org/2.2.6"
  val latestVersion = "2.2.6"
  val latestSuperSafeVersion = "1.1.0-RC7"
  val milestoneVersion = "3.0.0-RC4"
  val milestoneJar = "https://oss.sonatype.org/content/groups/public/org/scalactic/scalactic_2.11/3.0.0-RC4/scalactic_2.10-3.0.0-RC4.jar"
  val latestJar = "https://oss.sonatype.org/content/groups/public/org/scalactic/scalactic_2.11/2.2.6/scalactic_2.10-2.2.6.jar"
  val milestoneScaladoc = "http://www.artima.com/docs-scalatest-3.0.0-RC4"
  val scaladocsLocation = "http://doc.scalatest.org"
  val releasesLocation = "http://www.artima.com/downloadScalaTest"
  val baseScalaVersion = "2.11.0"
  val majorMinorScalaVersion = "2.11"

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
