package controllers

import javax.inject.Inject
import models.CursorReq
import models.services.TwitterService
import play.api.libs.json.Json
import play.api.mvc.{MessagesAbstractController, MessagesControllerComponents}
import utils.FormatJson._
import utils.ValidateJson

import scala.concurrent.ExecutionContext

class TwitterApiController @Inject()(twitterService: TwitterService)
                                    (cc: MessagesControllerComponents)
                                    (implicit ec: ExecutionContext) extends MessagesAbstractController(cc) with ValidateJson {

  def followers(screenName: String) = Action.async(validateJson[CursorReq]) { implicit request =>
    val cursor = request.body.cursor.getOrElse(-1L)
    twitterService.fetchFollowerIds(screenName, cursor).map { ids =>
      Ok(Json.toJson(ids))
    }.recover {
      case e: Exception => NotFound(e.toString)
    }
  }

  def followerInfos(screenName: String) = Action.async(validateJson[CursorReq]) { implicit request =>
    val cursor = request.body.cursor.getOrElse(-1L)
    twitterService.fetchFollowersForUser(screenName, cursor).map { users =>
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
