package models.services

import com.danielasfregola.twitter4s.TwitterRestClient
import javax.inject.Inject
import models.TwitterUser

import scala.concurrent.ExecutionContext

class TwitterService @Inject()(implicit ec: ExecutionContext) {
  val restClient = TwitterRestClient()

  def fetchFollowerIds(screenName: String, count: Int = 5000) = {
    restClient.followerIdsForUser(screenName, cursor = -1, count = count).map { response =>
      response.data.ids
    }
  }

  def fetchFollowersForUser(screenName: String, count: Int = 20) = {
    restClient.followersForUser(screenName, count = count).map { response =>
      response.data.users.map { user =>
        TwitterUser(
          user.id,
          user.screen_name,
          user.email,
          user.followers_count,
          user.friends_count,
          user.description,
          user.url,
          user.created_at)
      }
    }
  }

  def fetchUserDetail(id: Long) = {
    restClient.userById(id).map { response =>
      val user = response.data

      TwitterUser(
        user.id,
        user.screen_name,
        user.email,
        user.followers_count,
        user.friends_count,
        user.description,
        user.url,
        user.created_at)
    }
  }

  def fetchUserDetail(screenName: String) = {
    restClient.user(screenName).map { response =>
      val user = response.data

      TwitterUser(
        user.id,
        user.screen_name,
        user.email,
        user.followers_count,
        user.friends_count,
        user.description,
        user.url,
        user.created_at)
    }
  }
}
