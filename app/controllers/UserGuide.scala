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

object UserGuide extends Controller {

  def userGuideIndex = Action {
    Ok(views.html.userGuide.userGuideIndex())
  }

  def customEquality = Action {
    Ok(views.html.userGuide.customEquality())
  }

  def defaultEquality = Action {
    Ok(views.html.userGuide.defaultEquality())
  }

  def constrainedEquality = Action {
    Ok(views.html.userGuide.constrainedEquality())
  }

  def tolerance = Action {
    Ok(views.html.userGuide.Tolerance())
  }

  def normalization = Action {
    Ok(views.html.userGuide.Normalization())
  }

  def explicitly = Action {
    Ok(views.html.userGuide.Explicitly())
  }

  def orAndEvery = Action {
    Ok(views.html.userGuide.OrAndEvery())
  }

  def catcher = Action {
    Ok(views.html.userGuide.Catcher())
  }

  def prettifier = Action {
    Ok(views.html.userGuide.Prettifier())
  }

  def timesOnInt = Action {
    Ok(views.html.userGuide.TimesOnInt())
  }
}
