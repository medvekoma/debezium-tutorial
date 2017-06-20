# debezium tutorial

This tutorial is based on the [official debezium tutorial](http://debezium.io/docs/tutorial/) 
and enhances it by using confluent's docker containers with a custom Kafka Connect container
that embeds Debezium's MySQL connector.

Steps to reproduce:

## Start the required services

```bash
cd confluent
docker-compose up -d
```

This will start the following services:
 - zookeeper
 - kafka
 - mysql with example database
 - kafka connector with debezium
 - kafka watcher
 
## Create a connector

```bash
./create-connector.sh
```

This command will create a connector to the inventory database.

## Inspect logs

```bash
docker logs confluent_watcher_1
```

You should see the table bootstrap messages

## Start mysql terminal

```bash
./mysql-terminal.sh
```

This mysql command prompt can be used to make further changes in the database.

## Remove all containers

```bash
docker-compose down
```