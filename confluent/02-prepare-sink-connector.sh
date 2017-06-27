#!/usr/bin/env bash
docker exec -it confluent_connect_1 mkdir -p /root/.aws
docker cp ~/.aws/config confluent_connect_1:/root/.aws/
