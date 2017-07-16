package org.precompiler.spark101.utils

import java.sql.{Connection, DriverManager}

import org.scalatest.BeforeAndAfterAll

/**
  *
  * @author Richard Li
  */
trait H2DatabaseEnv {
  self: BeforeAndAfterAll =>
  var conn: Connection = null

  protected def getInitScriptPath(): String = {
    null
  }

  protected def getDBUrl(): String = {
    "jdbc:h2:mem:testDB"
  }

  protected def getDBUser(): String = {
    "sa"
  }

  protected def getDBPassword(): String = {
    ""
  }

  override protected def beforeAll(): Unit = {
    Class.forName("org.h2.Driver")
    var dbUrl = getDBUrl()
    if (getInitScriptPath() != null) {
      dbUrl += s";INIT=runscript from '${getInitScriptPath()}'"
    }
    conn = DriverManager.getConnection(dbUrl, getDBUser(), getDBPassword())
  }

  override protected def afterAll(): Unit = {
    if (conn != null) {
      conn.close()
    }
  }
}
