#!/usr/bin/env bash
curl -i -X PUT \
  -H "Accept:application/json" \
  -H "Content-Type:application/json" \
  localhost:8083/connectors/mysql-source-connector/config \
  -d '{
      "connector.class": "io.debezium.connector.mysql.MySqlConnector",
      "tasks.max": "1",
      "database.hostname": "mysql",
      "database.port": "3306",
      "database.user": "debezium",
      "database.password": "dbz",
      "database.server.id": "100001",
      "database.server.name": "dbserver1",
      "database.whitelist": "inventory",
      "table.whitelist": "inventory.products,inventory.customers,inventory.products_on_hand",
      "database.history.kafka.bootstrap.servers": "broker:9092",
      "database.history.kafka.topic": "dbhistory.inventory"
  }'
