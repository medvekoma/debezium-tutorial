#!/usr/bin/env bash
docker exec -it confluent_broker_1 kafka-topics --zookeeper zookeeper:2181 --list

