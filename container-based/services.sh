#!/usr/bin/env bash
docker run -d --name zookeeper -p 2181:2181 -p 2888:2888 -p 3888:3888 debezium/zookeeper:0.5
docker run -d --name kafka -p 9092:9092 --link zookeeper:zookeeper debezium/kafka:0.5
docker run -d --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=debezium -e MYSQL_USER=mysqluser -e MYSQL_PASSWORD=mysqlpw debezium/example-mysql:0.5
docker run -d --name connect -p 8083:8083 -e GROUP_ID=1 -e CONFIG_STORAGE_TOPIC=my_connect_configs -e OFFSET_STORAGE_TOPIC=my_connect_offsets --link zookeeper:zookeeper --link kafka:kafka --link mysql:mysql debezium/connect:0.5
docker run -d --name watcher --link zookeeper:zookeeper debezium/kafka:0.5 watch-topic -a -k dbserver1.inventory.customers