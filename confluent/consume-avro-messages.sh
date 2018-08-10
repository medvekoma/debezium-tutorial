#!/bin/bash

TOPIC=${1:-dbserver1.inventory.customers}

docker exec -it confluent_connect_1 kafka-avro-console-consumer \
  --bootstrap-server broker:9092 \
  --topic $TOPIC \
  --from-beginning \
  --property schema.registry.url=http://schema_registry:8081

