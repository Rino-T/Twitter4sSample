package models.dao

import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

trait DaoSlick extends DBTableDefinition with HasDatabaseConfigProvider[JdbcProfile]
