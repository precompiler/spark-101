package org.precompiler.spark101.movielens

import com.datastax.driver.core.ConsistencyLevel
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.precompiler.spark101.util.ParameterizedApp
import com.datastax.spark.connector._
import com.datastax.spark.connector.writer.WriteConf


/**
  * Spark application to load movie data (csv file) into Cassandra.
  *
  * @author Richard Li
  */
object FileLoaderApp extends ParameterizedApp {
  def main(args: Array[String]): Unit = {
    val props = loadProperties()
    val master = props.getString("spark.master")
    val movieFilePath = props.getString("movie.file.path")
    val ratingFilePath = props.getString("rating.file.path")
    val cassandraHost = props.getString("cassandra.host")
    val conf = new SparkConf().setAppName("File Loader").set("spark.cassandra.connection.host", cassandraHost).setMaster(master)
    val sparkSession = SparkSession.builder().config(conf).getOrCreate()
    try {
      val movieDF = sparkSession.read.option("header", "true").csv(movieFilePath)
      val ratingDF = sparkSession.read.option("header", "true").csv(ratingFilePath)
      ratingDF.createOrReplaceTempView("rating")
      movieDF.createOrReplaceTempView("movie")
      val movieRatingDF = sparkSession.sql(
        """select movie.movieId,
                  movie.title,
                  regexp_extract(movie.title, '.*\\((\\d{4})\\)', 1) year,
                  movie.genres,
                  round(avg(rating.rating),2) avg_rating
           from movie, rating
          where movie.movieId = rating.movieId
       group by movie.movieId, movie.title, movie.genres""")
      movieRatingDF.rdd.map(row => (row.getAs[String]("title"), row.getAs[String]("year"), row.getAs[String]("genres"), row.getAs[Double]("avg_rating")))
        .saveToCassandra("demo", "movie_avg_rating", SomeColumns("title", "year", "genres", "avg_rating"), WriteConf(consistencyLevel = ConsistencyLevel.ONE))
    } finally {
      sparkSession.stop()
    }
  }
}
