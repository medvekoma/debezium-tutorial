import io.confluent.kafka.serializers.KafkaAvroDecoder
import org.apache.avro.generic.GenericData
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.immutable.HashMap

object TopicInspector extends App {

  private val topics = Set("dbserver1")

  val conf = new SparkConf()
    .setAppName("avro-inspector")
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

  private val directKafkaStream = KafkaUtils.createDirectStream[Object, Object, KafkaAvroDecoder, KafkaAvroDecoder](
    scc, kafkaParams, topics)

  directKafkaStream.foreachRDD(rdd => {
    rdd.foreach(_ match {
      case (key: GenericData.Record, value: GenericData.Record) => {
        println(s"key: $key")
        println(s"key.class: ${key.getClass}")
        println(s"key schema: ${key.getSchema}")
        println(s"key schema fullName: ${key.getSchema.getFullName}")

        println(s"value: $value")
        println(s"value.class: ${value.getClass}")
        println(s"value schema: ${value.getSchema.toString}")
        println(s"value schema fullName: ${value.getSchema.getFullName}")

        println()
      }
      case (key, value) => {
        println(s"ERROR: key '$key' is ${key.getClass}; value '$value' is ${value.getClass}.")
        println()
      }
    })
  })

  scc.start()
  scc.awaitTermination()
}
