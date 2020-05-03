package forms

object ScreenNameForm {
  import play.api.data._
  import play.api.data.Forms._

  case class Data(screenName: String)

  val screenNameForm = Form(
    mapping(
      "screenName" -> nonEmptyText
    )(Data.apply)(Data.unapply)
  )
}