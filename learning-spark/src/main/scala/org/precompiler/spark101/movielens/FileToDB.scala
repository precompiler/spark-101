package org.precompiler.spark101.movielens

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.precompiler.spark101.movielens.FileLoaderApp.loadProperties
import org.precompiler.spark101.util.ParameterizedApp

/**
  *
  * @author Richard Li
  */
object FileToDB extends ParameterizedApp {
  def main(args: Array[String]): Unit = {

//    val props = loadProperties()
//    val master = props.getString("spark.master")
//    val movieFilePath = props.getString("movie.file.path")
//    val ratingFilePath = props.getString("rating.file.path")
//    val conf = new SparkConf().setAppName("File Loader").setMaster(master)
//    val sparkSession = SparkSession.builder().config(conf).getOrCreate()
//    try {
//      sparkSession.read.format("jdbc").option("url", "jdbc:h2:~/test")
//    } finally {
//      sparkSession.stop()
//    }


  }
}
