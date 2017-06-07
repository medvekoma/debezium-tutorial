# debezium tutorial

This tutorial is based on the [official debezium tutorial](http://debezium.io/docs/tutorial/).

The version in the `avro` branch uses a modified kafka connector (source code in `debezium_connect` subfolder) that enables avro serialization.

Steps to reproduce:

## Start the required services

```bash
docker-compose up -d
```

This will start the following services:
 - zookeeper
 - kafka
 - mysql with example database
 - debezium connector (custom build)
 - kafka watcher
 - schema repository (confluent inc)
 
## Create a connector

```bash
./create-connector.sh
```

This command will create a connector to the inventory database.

## Inspect logs

```bash
docker logs debeziumtutorial_watcher_1
```

You should see the table bootstrap messages

## Start mysql terminal

```bash
./mysql-terminal.sh
```

This mysql command prompt can be used to make further changes in the database.

```sql
USE inventory;
UPDATE customers SET first_name = "Anne Marie" WHERE id = 1004;
```

Inspect the logs again

```bash
docker logs debeziumtutorial_watcher_1
```

## Remove all containers

```bash
docker stop mysqlterm
docker rm mysqlterm
docker-compose down
```
