import io.confluent.kafka.serializers.KafkaAvroDecoder
import org.apache.avro.generic.GenericData
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.immutable.HashMap

object AvroTopicInspector extends App {

  val conf = new SparkConf()
    .setAppName("avro-topic-inspector")
    .setMaster("local[*]")

  val spark = SparkSession.builder
    .appName("avro-topic-inspector")
    .master("local[*]")
    .getOrCreate()

  val scc = new StreamingContext(spark.sparkContext, Seconds(15))
  val kafkaParams = HashMap(
    "metadata.broker.list" -> "localhost:9092",
    "auto.offset.reset"    -> "smallest",
    "zookeeper.connect"    -> "localhost:2181",
    "group.id"             -> "group1",
    "schema.registry.url"  -> "http://localhost:8081"
  )

  private val topics = Set("dbserver1.inventory.customers")

  private val directKafkaStream = KafkaUtils.createDirectStream[Object, Object, KafkaAvroDecoder, KafkaAvroDecoder](
    scc, kafkaParams, topics)

  directKafkaStream.foreachRDD(rdd => {
    rdd.foreach {
      case (key, value) => {
        println("-" * 40)

        println(s"key: $key")
        printInfo(key)

        println(s"value: $value")
        printInfo(value)
      }
    }
  })

  private def printInfo(value: Object) = {

    val classNameOption = Option(value).map(_.getClass).map(_.toString)
    classNameOption match {
      case Some(className) =>
        println(s"  - class: $className")
      case None =>
    }

    value match {
      case record: GenericData.Record =>
        println(s"  - schema: ${record.getSchema}")
        println(s"  - schema fullName: ${record.getSchema.getFullName}")
      case _ =>
    }
  }

  scc.start()
  scc.awaitTermination()
}
