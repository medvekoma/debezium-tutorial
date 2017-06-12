package com.flixbus.ff.debeziumpoc;


import io.confluent.kafka.serializers.KafkaAvroDecoder;
import org.apache.avro.generic.GenericData;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaPairInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AvroReader {

    public static final String KAFKA_TOPIC = "dbserver1";
//    public static final String KAFKA_TOPIC = "dbserver1.inventory.customers";

    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf()
                .setAppName("kafka-sandbox")
                .setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaStreamingContext ssc = new JavaStreamingContext(sc, new Duration(TimeUnit.MINUTES.toMillis(1)));

        Set<String> topics = Collections.singleton(KAFKA_TOPIC);
        Map<String, String> kafkaParams = new HashMap<>();
        kafkaParams.put("metadata.broker.list", "localhost:9092");
        kafkaParams.put("auto.offset.reset", "smallest");
        kafkaParams.put("zookeeper.connect", "localhost:2181");
        kafkaParams.put("group.id", "group1");
        kafkaParams.put("schema.registry.url", "http://localhost:8081");

        JavaPairInputDStream<Object, Object> directKafkaStream = KafkaUtils.createDirectStream(
                ssc, Object.class, Object.class, KafkaAvroDecoder.class, KafkaAvroDecoder.class, kafkaParams, topics);

        directKafkaStream.foreachRDD(rdd -> {
            rdd.foreach(avroRecord -> {
                System.out.println("key: " + avroRecord._1());
                System.out.println("key.class: " + avroRecord._1().getClass());
                GenericData.Record key = (GenericData.Record) avroRecord._1();
                System.out.println("key schema: " + key.getSchema().toString());
                System.out.println("key schema fullName: " + key.getSchema().getFullName());


                System.out.println("value: " + avroRecord._2());
                System.out.println("value.class: " + avroRecord._2().getClass());
                GenericData.Record value = (GenericData.Record) avroRecord._2();
                System.out.println("value schema: " + value.getSchema().toString());
                System.out.println("value schema fullName: " + value.getSchema().getFullName());

                System.out.println();

            });
        });

        ssc.start();
        ssc.awaitTermination();
    }
}
