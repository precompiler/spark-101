package org.precompiler.spark101.helloworld

//import org.apache.spark.sql.SQLContext
//import org.apache.spark.{SparkConf, SparkContext}
import org.precompiler.spark101.env.EnvSetup

import scala.util.{Success, Try}

/**
  *
  * @author Richard Li
  */
object HelloWorldApp extends EnvSetup {
  def main(args: Array[String]): Unit = {
    //setupMockHadoop()
    //    val conf = new SparkConf().setAppName("Hello World").setMaster("local[4]")
    //    val sc = new SparkContext(conf)
    //    val rdd = sc.parallelize(Array[String]("Hello", "World"))
    //    rdd.map(s => println(s)).collect()
    //    sc.stop()
    val conn = new MockConnection()
    val ret = Try {
      println("in Try block")

      throw new RuntimeException("Error!!!")
    }.flatMap((v) => {
      println("haha" + v)
      Success(v)
    })
    conn.close()
    println(ret)
    // println(result)
  }
}
