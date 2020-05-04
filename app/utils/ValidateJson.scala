package utils

import play.api.libs.json.{JsError, Reads}
import play.api.mvc.{PlayBodyParsers, Results}
import slick.util.Logging

import scala.concurrent.ExecutionContext

trait ValidateJson extends Logging {
  implicit def parse: PlayBodyParsers

  def validateJson[A: Reads](implicit ec: ExecutionContext) = {
    parse.json.validate(_.validate[A].asEither.left.map(e => Results.BadRequest(JsError.toJson(e))))
  }
}
