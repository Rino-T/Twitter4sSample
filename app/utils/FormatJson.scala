package utils

import models.{CursorReq, TwitterIds, TwitterUser, TwitterUsers}
import play.api.libs.json.Json

object FormatJson {

  implicit val jsonCursorReq = Json.format[CursorReq]

  implicit val jsonTwitterIds = Json.format[TwitterIds]

  implicit val jsonTwitterUser = Json.format[TwitterUser]

  implicit val jsonTwitterUsers = Json.format[TwitterUsers]
}
