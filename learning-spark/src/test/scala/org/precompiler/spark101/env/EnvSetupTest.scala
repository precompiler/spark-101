package org.precompiler.spark101.env

import org.scalatest.FunSuite

/**
  *
  * @author Richard Li
  */
class EnvSetupTest extends FunSuite with EnvSetup{
  test("getUserDir") {
    assert(System.getProperty("user.dir").equals(getUserDir()))
  }
}
