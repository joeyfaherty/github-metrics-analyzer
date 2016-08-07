#!/usr/bin/env bash
mvn clean package
docker build -f src/main/resources/docker/dockerfiles/Dockerfile .
docker run -p 8080:8080 $(docker images | awk '{print $3}' | awk 'FNR==2')