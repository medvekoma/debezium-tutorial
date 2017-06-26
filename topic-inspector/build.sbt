name := "topic-inspector"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "confluent" at "http://packages.confluent.io/maven/"

libraryDependencies += "io.confluent" % "kafka-avro-serializer" % "3.2.1"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.1"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.1.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.1.1"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.6.3"
// libraryDependencies += "com.databricks" %% "spark-avro" % "3.2.0"
