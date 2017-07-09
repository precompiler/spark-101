package org.precompiler.spark101.db

import java.io.File
import java.sql.DriverManager

import org.precompiler.spark101.env.EnvSetup
import org.scalatest.FunSuite


/**
  *
  * @author Richard Li
  */
class H2Test extends FunSuite with EnvSetup {
  test("Embedded H2") {
    val dbUrl = "jdbc:h2:" + getUserDir() + File.separator + "testDB"
    Class.forName("org.h2.Driver")
    val conn = DriverManager.getConnection(dbUrl, "sa", "")
    // add application code here
    conn.close()
  }
}
