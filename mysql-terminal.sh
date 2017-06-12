#!/usr/bin/env bash
docker run -it --rm \
  --name mysqlterm \
  --network debeziumpoc_default \
  --link mysql mysql:5.7 \
  sh -c 'exec mysql -h"mysql" -P"3306" -uroot -p"debezium"'
