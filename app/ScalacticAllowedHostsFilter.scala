
import java.net.URL

import akka.util.ByteString
import javax.inject.Inject
import play.api.http.{HttpErrorHandler, Status}
import play.core.j.{JavaContextComponents, JavaHttpErrorHandlerAdapter}
import play.api.{Environment, Logger, Mode}
import play.api.mvc.{EssentialAction, EssentialFilter, RequestHeader, Result}
import play.api.libs.streams.Accumulator
import play.api.MarkerContexts.SecurityMarkerContext

import scala.io.Source
import scala.util.Try

case class ScalacticAllowedHostsFilter @Inject() (env: Environment, errorHandler: HttpErrorHandler)
  extends EssentialFilter {

  private val logger = Logger(this.getClass)

  // Java API
  def this(env: Environment, errorHandler: play.http.HttpErrorHandler, contextComponents: JavaContextComponents) {
    this(env, new JavaHttpErrorHandlerAdapter(errorHandler, contextComponents))
  }

  def httpGet(targetUrl: String): String = {
    val url = new URL(targetUrl)
    Source.fromURL(url).getLines().mkString.trim
  }

  private lazy val allowedHosts: Seq[String] =
    if (env.mode == Mode.Prod) {
      val privateIp = Try(httpGet("http://169.254.169.254/latest/meta-data/local-ipv4")).getOrElse("localhost")
      //val macAddress = httpGet("http://169.254.169.254/latest/meta-data/network/interfaces/macs/")
      //val vpcId = httpGet(s"http://169.254.169.254/latest/meta-data/network/interfaces/macs/${macAddress}/vpc-id")
      Vector("www.scalactic.org" , privateIp + ":9000", "scalactic.org")
    }
    else
      Vector("localhost:9000", "localhost:9443", "localhost:3333")

  lazy val performFilterFun: (RequestHeader, EssentialAction) => Accumulator[ByteString, Result] =
    (req: RequestHeader, next: EssentialAction) => {
      if (allowedHosts.contains(req.host))
        next(req)
      else {
        logger.warn(s"Host not allowed: ${req.host}")(SecurityMarkerContext)
        Accumulator.done(errorHandler.onClientError(req, Status.BAD_REQUEST, s"Host not allowed: ${req.host}"))
      }
    }

  lazy val testFilterFun: (RequestHeader, EssentialAction) => Accumulator[ByteString, Result] =
    (req: RequestHeader, next: EssentialAction) => {
      next(req)
    }

  lazy val filterFun: (RequestHeader, EssentialAction) => Accumulator[ByteString, Result] =
    if (env.mode == Mode.Test)
      testFilterFun
    else
      performFilterFun

  override def apply(next: EssentialAction) = EssentialAction { req =>
    filterFun(req, next)
  }
}
