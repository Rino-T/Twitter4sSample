package models.services

import com.danielasfregola.twitter4s.TwitterRestClient
import javax.inject.Inject
import models.{TwitterIds, TwitterUser, TwitterUsers}

import scala.concurrent.ExecutionContext

class TwitterService @Inject()(implicit ec: ExecutionContext) {
  val restClient = TwitterRestClient()

  def fetchFollowerIds(screenName: String, cursor: Long = -1, count: Int = 5000) = {
    restClient.followerIdsForUser(screenName, cursor, count).map { response =>
      TwitterIds(response.data.ids, response.data.next_cursor, response.data.previous_cursor)
    }
  }

  def fetchFollowersForUser(screenName: String, cursor: Long = -1, count: Int = 20) = {
    restClient.followersForUser(screenName, cursor, count).map { response =>
      val users = response.data.users.map { user =>
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

      TwitterUsers(users, response.data.next_cursor, response.data.previous_cursor)
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
