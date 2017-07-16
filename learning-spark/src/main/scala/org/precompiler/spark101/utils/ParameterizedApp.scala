package org.precompiler.spark101.utils

import com.typesafe.config.{Config, ConfigFactory}

/**
  *
  * @author Richard Li
  */
trait ParameterizedApp {
  def loadProperties(path: String = "application.properties"): Config = {
    ConfigFactory.load(path)
  }
}
