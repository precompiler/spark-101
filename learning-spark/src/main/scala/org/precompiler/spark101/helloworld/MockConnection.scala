package org.precompiler.spark101.helloworld

/**
  *
  * @author Richard Li
  */
class MockConnection {
  def close(): Unit = {
    println("Connection closed")
  }
}
