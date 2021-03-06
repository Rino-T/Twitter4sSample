package controllers

import com.danielasfregola.twitter4s.exceptions.TwitterException
import javax.inject.Inject
import models.services.TwitterService
import play.api.Configuration
import play.api.mvc.{MessagesAbstractController, MessagesControllerComponents}

import scala.concurrent.ExecutionContext

class TwitterController @Inject()(twitterService: TwitterService, config: Configuration)(cc: MessagesControllerComponents)
                                 (implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  import forms.ScreenNameForm._

  def index = Action.async { implicit request =>
    val myTwitterScreenName = config.get[String]("twitter.myAccount.screenName")
    twitterService.fetchUserDetail(myTwitterScreenName).map { user =>
      Ok(views.html.index(user))
    }
  }

  def searchFollowerIds = Action { implicit request =>
    Ok(views.html.search(screenNameForm))
  }

  def fetchFollowerIds = Action { implicit request =>
    val form = screenNameForm.bindFromRequest
    val data = form.get
    Redirect(routes.TwitterController.followerIds(data.screenName, Some(-1L)))
  }

  def followerIds(screenName: String, cursor: Option[Long]) = Action.async { implicit request =>
    twitterService.fetchFollowerIds(screenName, cursor.getOrElse(-1)).map { ids =>
      Ok(views.html.follower.followerIds(ids, screenName))
    }.recover {
      case e: TwitterException => NotFound(views.html.sorry(e))
      case e: Exception => InternalServerError(views.html.sorry(e))
    }
  }

  def followerDetailTable(screenName: String, cursor: Option[Long]) = Action.async { implicit request =>
    twitterService.fetchFollowersForUser(screenName, cursor.getOrElse(-1)).map { users =>
      Ok(views.html.follower.followerDetailList(users, screenName))
    }
  }
}
