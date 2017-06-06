#!/usr/bin/env bash
docker run -it --name watcher --rm --link zookeeper:zookeeper debezium/kafka:0.5 watch-topic -a -k dbserver1.inventory.customers
