package controllers

import javax.inject.Inject
import models.services.TwitterService
import play.api.libs.json.Json
import play.api.mvc.{MessagesAbstractController, MessagesControllerComponents}
import utils.FormatJson._

import scala.concurrent.ExecutionContext

class TwitterApiController @Inject()(twitterService: TwitterService)(cc: MessagesControllerComponents)
                                    (implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def followers(screenName: String) = Action.async { implicit request =>
    twitterService.fetchFollowerIds(screenName).map { ids =>
      Ok(Json.toJson(ids))
    }
  }

  def followerInfos(screenName: String) = Action.async { implicit request =>
    twitterService.fetchFollowersForUser(screenName).map { users =>
      Ok(Json.toJson(users))
    }
  }

  def userDetailById(id: Long) = Action.async { implicit request =>
    twitterService.fetchUserDetail(id).map { user =>
      Ok(Json.toJson(user))
    }
  }

  def userDetailByScreenName(screenName: String) = Action.async { implicit request =>
    twitterService.fetchUserDetail(screenName).map { user =>
      Ok(Json.toJson(user))
    }
  }
}
