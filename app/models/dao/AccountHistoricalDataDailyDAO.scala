package models.dao

import java.time.Instant

import models.AccountHistoricalDataDaily

import scala.concurrent.Future

trait AccountHistoricalDataDailyDAO {

  def all: Future[Seq[AccountHistoricalDataDaily]]

  def find(id: Int): Future[AccountHistoricalDataDaily]

  def find(date: Instant): Future[AccountHistoricalDataDaily]

  def insert(data: AccountHistoricalDataDaily): Future[Boolean]

  def update(data: AccountHistoricalDataDaily): Future[Boolean]

  def delete(data: AccountHistoricalDataDaily): Future[Boolean]
}
