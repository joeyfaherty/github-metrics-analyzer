#!/usr/bin/env bash

# container cleanup
echo "Step 1"
echo "stopping and removing all running docker containers"
docker rm $(docker stop $(docker ps -aq))

# run postgres image
echo "Step 2"
echo "starting postgres container"
docker run --name joey-postgres -e POSTGRES_PASSWORD=password -d postgres:9.4

echo "Step 3"
echo "Build project and start app container"
mvn clean package
docker build -f src/main/resources/docker/dockerfiles/Dockerfile .
docker run -p 8080:8080 $(docker images | awk '{print $3}' | awk 'FNR==2') &

