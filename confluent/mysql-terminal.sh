#!/usr/bin/env bash
docker exec -it confluent_mysql_1 \
  mysql -h"mysql" -P"3306" -uroot -p"debezium"
