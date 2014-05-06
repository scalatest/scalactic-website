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
package test

import org.scalatest._

import play.api.test._
import play.api.test.Helpers._

class ExampleUnitSpec extends UnitSpec {
  
  "Application" should {
    
    "send 404 on a bad request" in running(FakeApplication()) {
      route(FakeRequest(GET, "/boum")) shouldBe None
    }
    
    "render the index page" in running(FakeApplication()) {
      val home = route(FakeRequest(GET, "/")).get
        
      status(home) shouldBe OK
      contentType(home).value shouldBe "text/html"
      contentAsString(home) should include ("Scalactic")
    }
  }
}
