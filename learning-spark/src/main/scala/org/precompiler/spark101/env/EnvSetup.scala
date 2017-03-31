package org.precompiler.spark101.env

import java.io.File

/**
  *
  * @author Richard Li
  */
trait EnvSetup {
  private val winutilsPath = getUserDir() + File.separator + "src" + File.separator + "main" + File.separator + "resources"

  def setupMockHadoop(): Unit = {
    if (isWindows()) {
      System.setProperty("hadoop.home.dir", winutilsPath)
    }
  }

  def isWindows(): Boolean = {
    System.getProperty("os.name").startsWith("Windows")
  }

  def getUserDir(): String = {
    System.getProperty("user.dir")
  }
}
