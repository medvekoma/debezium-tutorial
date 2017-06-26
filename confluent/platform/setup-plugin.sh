#!/usr/bin/env bash

DEBEZIUM_VERSION=0.5.0
MAVEN_CENTRAL="https://repo1.maven.org/maven2"
KAFKA_CONNECT_PLUGINS_DIR="/opt/confluent/share/java/kafka-connect-debezium"
KAFKA_CONNECT_CONFIG_DIR="/opt/confluent/etc/kafka-connect-debezium"

mkdir -p $KAFKA_CONNECT_PLUGINS_DIR
mkdir -p $KAFKA_CONNECT_CONFIG_DIR

# deploy debezium plugin
curl -fSL -o /tmp/plugin.tar.gz \
    $MAVEN_CENTRAL/io/debezium/debezium-connector-mysql/$DEBEZIUM_VERSION/debezium-connector-mysql-$DEBEZIUM_VERSION-plugin.tar.gz

echo "46b09d28d53c9aa997e55ac29e0754eb  /tmp/plugin.tar.gz" | md5sum -c -
tar -xzf /tmp/plugin.tar.gz -C $KAFKA_CONNECT_PLUGINS_DIR --strip 1
rm -f /tmp/plugin.tar.gz

# deploy debezium plugin config
cp quickstart-debezium.properties $KAFKA_CONNECT_CONFIG_DIR/
