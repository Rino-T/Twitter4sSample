package models.dao

import java.sql.Timestamp
import java.time.Instant

import models.AccountHistoricalDataDaily
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

trait DBTableDefinition { self: HasDatabaseConfigProvider[JdbcProfile] =>

  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import profile.api._

  implicit val instantColumnType: BaseColumnType[Instant] = MappedColumnType.base[Instant, Timestamp](instant => Timestamp.from(instant), ts => ts.toInstant)

  class AccountHistoricalDataDailyTable(tag: Tag) extends Table[AccountHistoricalDataDaily](tag, "AccountHistoricalDataDaily") {

    val id = column[Int]("id", O.PrimaryKey, O.AutoInc)

    val screenName = column[String]("screenName")

    val twitterId = column[Long]("twitterId")

    val followerCount = column[Int]("followerCount")

    val followCount = column[Int]("followCount")

    val date = column[Instant]("date")

    def * = (id, screenName, twitterId, followerCount, followCount, date) <> (AccountHistoricalDataDaily.tupled, AccountHistoricalDataDaily.unapply)
  }

  val accountHistoricalDataDailyTable = TableQuery[AccountHistoricalDataDailyTable]
}

