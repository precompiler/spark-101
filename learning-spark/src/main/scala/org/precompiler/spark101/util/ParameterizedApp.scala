package org.precompiler.spark101.util

import com.typesafe.config.{Config, ConfigFactory}

/**
  *
  * @author Richard Li
  */
class ParameterizedApp {
  def loadProperties(path: String = "application.properties"): Config = {
    ConfigFactory.load(path)
  }
}
