import io.confluent.kafka.serializers.KafkaAvroDecoder
import org.apache.avro.generic.GenericData
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.immutable.HashMap

object AvroTopicInspector extends App {

  val conf = new SparkConf()
    .setAppName("avro-topic-inspector")
    .setMaster("local[*]")

  val sc = new SparkContext(conf)
  val scc = new StreamingContext(sc, Seconds(15))
  val kafkaParams = HashMap(
    "metadata.broker.list" -> "localhost:9092",
    "auto.offset.reset"    -> "smallest",
    "zookeeper.connect"    -> "localhost:2181",
    "group.id"             -> "group1",
    "schema.registry.url"  -> "http://localhost:8081"
  )

  private val topics = Set("dbserver1", "dbserver1.inventory.customers")

  private val directKafkaStream = KafkaUtils.createDirectStream[Object, Object, KafkaAvroDecoder, KafkaAvroDecoder](
    scc, kafkaParams, topics)

  directKafkaStream.foreachRDD(rdd => {
    rdd.foreach {
      case (key, value) => {
        println("-" * 30)

        println(s"key: $key")
        printInfo(key)

        println(s"value: $value")
        printInfo(value)
      }
    }
  })

  private def printInfo(record: Object) = {
    val maybeClassName = Option(record).map(_.getClass).map(_.toString)
    maybeClassName match {
      case Some(className) =>
        println(s"    class: $className")
      case None =>
    }

    val schemaOption = Option(record.asInstanceOf[GenericData.Record]).map(_.getSchema)
    schemaOption match {
      case Some(schema) =>
        println(s"    schema: ${schema}")
        println(s"    schema fullName: ${schema.getFullName}")
      case None =>
    }
  }

  scc.start()
  scc.awaitTermination()
}
