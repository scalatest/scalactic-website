import javax.inject.{Singleton}
import play.api.mvc.{EssentialAction, EssentialFilter, RequestHeader, Result}
import javax.inject.Inject
import akka.util.ByteString
import play.api.libs.streams.Accumulator
import scala.concurrent.ExecutionContext.Implicits.global


object HSTSFilter {
  /**
    * @return an HSTSFilter.
    */
  def apply(): HSTSFilter = {
    new HSTSFilter()
  }
}

@Singleton
class HSTSFilter @Inject() () extends EssentialFilter {

  def apply(nextFilter: EssentialAction) = new EssentialAction {

    def apply(requestHeader: RequestHeader) = {
      val accumulator: Accumulator[ByteString, Result] = nextFilter(requestHeader)
      accumulator.map { result =>

        if (requestHeader.host contains "www.scalactic.org") {
          // provide HTTP Strict Transport Security header with max age of 1 day (86400 seconds)
          //result.withHeaders("Strict-Transport-Security" -> "max-age=86400; includeSubDomains")  // reminder: how to add sub-domains
          result.withHeaders("Strict-Transport-Security" -> "max-age=86400")
        }
        else {
          result
        }
      }
    }

  }

}
