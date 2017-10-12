#!/usr/bin/env bash
curl -i -X POST \
  -H "Accept:application/json" \
  -H "Content-Type:application/json" \
  localhost:8083/connectors/ \
  -d '{
    "name": "mysql-source-connector-orders",
    "config": {
      "connector.class": "io.debezium.connector.mysql.MySqlConnector",
      "tasks.max": "1",
      "database.hostname": "mysql",
      "database.port": "3306",
      "database.user": "debezium",
      "database.password": "dbz",
      "database.server.id": "100002",
      "database.server.name": "dbserver1",
      "database.whitelist": "inventory",
      "table.whitelist": "inventory.orders",
      "database.history.kafka.bootstrap.servers": "broker:9092",
      "database.history.kafka.topic": "dbhistory.inventory"
    }
  }'
