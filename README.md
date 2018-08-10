# debezium tutorial

This tutorial is a step-by-step guide for building a data pipeline
from MySQL to S3, using the following components:
 - Confluent Platform
 - Debezium (MySQL Kafka connector)
 - Docker and Docker Compose
 
## content

* The `confluent` folder contains the docker-compose files and also shell scripts to start and monitor the pipeline
* The `topic-inspector` folder contains a spark streaming application written in Scala for inspecting the Kafka topics.

## steps to reproduce

Go into the `confluent` folder.

```bash
cd confluent
```

### start the required services

```bash
docker-compose up -d
```

This will start the following services:
 - zookeeper
 - kafka
 - mysql with example database
 - kafka connector with debezium
 - kafka watcher
 
### create a source connector

The script below will register and start the MySQL source connector,
that will start streaming MySQL changes into Kafka topics

```bash
./01-create-source-connector.sh
```

Once the connector is started, it streams the bootstrap messages into Kafka.

### inspect topics

```bash
./consume-avro-messages.sh <topic>
```

This command translates the avro messages to json. 
The argument is the topic name and is optional.
It defaults to dbserver1.inventory.customers. 
To see the DDL messages, you can supply dbserver1

### start mysql terminal

You can start a MySQL terminal and make changes to the database.
```bash
./mysql-terminal.sh
```

```sql
USE inventory;
UPDATE customers SET first_name = "Annemarie" WHERE id = 1004;
```

### register the sink connector

First we need to prepare the sink connector by adding the AWS credentials, 
then, similarly to the source connector.

```bash
./02-prepare-sink-connector.sh
./03-create-sink-connector.sh
```

Once this is done, the avro files should appear at `s3://debezium-poc-sink`

### Remove all containers

```bash
docker-compose down
```