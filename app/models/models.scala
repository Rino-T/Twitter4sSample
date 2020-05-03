package models

import java.time.Instant

case class TwitterUserInfo(
  id: Long
)

case class TwitterUser(
  id: Long,
  screenName: String,
  email: Option[String],
  followersCount: Int,
  friendsCount: Int,
  description: Option[String],
  url: Option[String],
  createdAt: Instant
)
