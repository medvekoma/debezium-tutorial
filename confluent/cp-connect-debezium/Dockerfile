FROM confluentinc/cp-kafka-connect:3.2.1

ENV DEBEZIUM_VERSION=0.5.0 \
    MAVEN_CENTRAL="https://repo1.maven.org/maven2" \
    KAFKA_CONNECT_PLUGINS_DIR="/usr/share/java/kafka"

# "/etc/kafka-connect/jars"

#
# Create a single `$KAFKA_CONNECT_PLUGINS_DIR/debezium` directory into which we'll place all of our JARs and files.
#
# Debezium connectors share some dependencies and JARs, so if we put each connector into a separate directory
# then we'd have JARs appearing in multiple places on Kafka Connect's flat classpath, and we'd get
# NoSuchMethod exceptions.

# RUN mkdir $DEBEZIUM_DIR

#
# Download MySQL connector, verify the contents, and then install into the `$KAFKA_CONNECT_PLUGINS_DIR/debezium` directory...
#
RUN curl -fSL -o /tmp/plugin.tar.gz \
                 $MAVEN_CENTRAL/io/debezium/debezium-connector-mysql/$DEBEZIUM_VERSION/debezium-connector-mysql-$DEBEZIUM_VERSION-plugin.tar.gz &&\
    echo "46b09d28d53c9aa997e55ac29e0754eb  /tmp/plugin.tar.gz" | md5sum -c - &&\
    tar -xzf /tmp/plugin.tar.gz -C $KAFKA_CONNECT_PLUGINS_DIR --strip 1 &&\
    rm -f /tmp/plugin.tar.gz
