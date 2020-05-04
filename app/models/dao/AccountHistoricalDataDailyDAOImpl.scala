package models.dao
import java.time.Instant

import javax.inject.Inject
import models.AccountHistoricalDataDaily
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.{ExecutionContext, Future}

class AccountHistoricalDataDailyDAOImpl @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
                                                 (implicit ec: ExecutionContext) extends AccountHistoricalDataDailyDAO with DaoSlick {

  import profile.api._

  override def all: Future[Seq[AccountHistoricalDataDaily]] = {
    val query = accountHistoricalDataDailyTable.result

    db.run(query)
  }

  override def find(id: Int): Future[AccountHistoricalDataDaily] = ???

  override def find(date: Instant): Future[AccountHistoricalDataDaily] = ???

  override def insert(data: AccountHistoricalDataDaily): Future[Boolean] = ???

  override def update(data: AccountHistoricalDataDaily): Future[Boolean] = ???

  override def delete(data: AccountHistoricalDataDaily): Future[Boolean] = ???
}
