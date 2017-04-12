package org.precompiler.spark101.env



import com.typesafe.config.ConfigFactory
import org.scalatest.FunSuite

/**
  *
  * @author Richard Li
  */
class TypesafeConfigTest extends FunSuite {
  test("loadConfigFile") {
    val conf = ConfigFactory.load("application-test.properties")
    assert("test1" == conf.getString("key"))
    val conf2 = ConfigFactory.load("conf/application-test.properties")
    assert("test2" == conf2.getString("key"))
  }
}
