package controllers

import javax.inject.Inject
import models.services.TwitterService
import play.api.mvc.{MessagesAbstractController, MessagesControllerComponents}

import scala.concurrent.ExecutionContext

class TwitterController @Inject()(twitterService: TwitterService)(cc: MessagesControllerComponents)
                                 (implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  import forms.ScreenNameForm._

  def index = Action { implicit request =>
    Ok(views.html.search(screenNameForm))
  }

  def fetchFollowerIds = Action { implicit request =>
    val form = screenNameForm.bindFromRequest
    val data = form.get
    Redirect(routes.TwitterController.followers(data.screenName))
  }

  def followers(screenName: String) = Action.async { implicit request =>
    twitterService.fetchFollowerIds(screenName).map { ids =>
      Ok(views.html.followers(ids))
    }
  }
}
