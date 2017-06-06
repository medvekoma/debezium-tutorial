#!/usr/bin/env bash
docker stop zookeeper kafka mysql connect watcher
docker rm   zookeeper kafka mysql connect watcher
