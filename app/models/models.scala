package models

import java.time.Instant

case class CursorReq(
  cursor: Option[Long]
)

case class TwitterIds(
  ids: Seq[Long],
  nextCursor: Long,
  previousCursor: Long
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

case class TwitterUsers(
  users: Seq[TwitterUser],
  nextCursor: Long,
  previousCursor: Long
)

case class AccountHistoricalDataDaily(
  id: Int,
  screenName: String,
  twitterId: Long,
  followerCount: Int,
  followCount: Int,
  date: Instant
)