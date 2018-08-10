#!/usr/bin/env bash
curl -i -X POST \
  -H "Accept:application/json" \
  -H "Content-Type:application/json" \
  localhost:8083/connectors/ \
  -d '{
    "name": "s3-sink-connector",
    "config": {
      "topics": "dbserver1.inventory.customers",
      "connector.class": "io.confluent.connect.s3.S3SinkConnector",
      "name": "debezium-poc-sink",
      "format.class": "io.confluent.connect.s3.format.avro.AvroFormat",
      "flush.size": 4,
      "s3.bucket.name": "debezium-poc-sink",
      "s3.region": "eu-central-1",
      "storage.class": "io.confluent.connect.s3.storage.S3Storage",
      "schema.generator.class": "io.confluent.connect.storage.hive.schema.DefaultSchemaGenerator"
    }
  }'
