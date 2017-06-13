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
      case (key: GenericData.Record, value: GenericData.Record) => {
        println("-" * 30)

        println(s"key: $key")
        println(s"key.class: ${key.getClass}")
        println(s"key schema: ${key.getSchema}")
        println(s"key schema fullName: ${key.getSchema.getFullName}")

        println(s"value: $value")
        println(s"value.class: ${value.getClass}")
        println(s"value schema: ${value.getSchema.toString}")
        println(s"value schema fullName: ${value.getSchema.getFullName}")
      }
    }
  })

  scc.start()
  scc.awaitTermination()
}
