package models.services

import com.danielasfregola.twitter4s.TwitterRestClient
import javax.inject.Inject

import scala.concurrent.ExecutionContext

class TwitterService @Inject()(implicit ec: ExecutionContext) {
  val restClient = TwitterRestClient()

  def fetchFollowerIds(screenName: String, count: Int = 5000) = {
    restClient.followerIdsForUser(screenName, cursor = -1, count = count).map { response =>
      response.data.ids
    }
  }
}
