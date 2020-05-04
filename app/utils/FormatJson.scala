package utils

import models.{TwitterIds, TwitterUser, TwitterUsers}
import play.api.libs.json.Json

object FormatJson {

  implicit val jsonTwitterIds = Json.format[TwitterIds]

  implicit val jsonTwitterUser = Json.format[TwitterUser]

  implicit val jsonTwitterUsers = Json.format[TwitterUsers]
}
