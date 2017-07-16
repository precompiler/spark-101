package org.precompiler.spark101.db

import java.io.File
import java.sql.{Connection, DriverManager}

import org.precompiler.spark101.env.EnvSetup
import org.precompiler.spark101.utils.H2DatabaseEnv
import org.scalatest.{BeforeAndAfterAll, FunSuite}


/**
  *
  * @author Richard Li
  */
class H2Test extends FunSuite with EnvSetup with BeforeAndAfterAll with H2DatabaseEnv {
  override protected def getInitScriptPath(): String = {
    getUserDir().replace("\\", "/") + "/src/test/resources/db/init.sql"
  }

  test("Embedded H2") {
    val rs = conn.createStatement().executeQuery("select count(*) from ut.movie_rating")
    while (rs.next()) {
      print(rs.getLong(1))
    }
  }
}

