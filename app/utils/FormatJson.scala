package utils

import com.danielasfregola.twitter4s.entities.User
import models.{TwitterUser, TwitterUserInfo}
import play.api.libs.json.Json

object FormatJson {
  implicit val jsonTwitterData = Json.format[TwitterUserInfo]

  implicit val jsonTwitterUser = Json.format[TwitterUser]
}
