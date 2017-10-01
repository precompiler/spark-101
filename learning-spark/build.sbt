name := "learning-spark"
version := "1.0.0"
scalaVersion := "2.11.8"
libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-core" % "2.1.0",
	"org.apache.spark" %% "spark-sql" % "2.1.0",
	"org.apache.spark" %% "spark-catalyst" % "2.1.0",
	"org.apache.spark" %% "spark-mllib" % "2.1.0",
	"com.datastax.spark" %% "spark-cassandra-connector" % "2.0.1",
	"com.typesafe" % "config" % "1.3.1",
	"org.scalatest" %% "scalatest" % "3.0.1" % "test",
	"junit" % "junit" % "4.12" % "test",
	"com.datastax.spark" %% "spark-cassandra-connector-embedded" % "2.0.1" % "test",
	"com.h2database" % "h2" % "1.4.196" % "test"
)