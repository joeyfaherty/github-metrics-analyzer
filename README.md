> Installation prerequisites: docker, maven, java

###### Please access the version page of this project in the following way:

* `git clone github-metrics-analyzer.git`
* `cd github-metrics-analyzer/`
* `chmod +x buildDockerContainerWithWar.sh`
* `./buildDockerContainerWithWar.sh`

URL: `LOCAL_IP:8080/github-metrics/webapi/current-version`

***

> *buildDockerContainerWithWar.sh:*

* builds the project and creates a WAR file.
* builds a docker image from the Dockerfile in src/main/resources/docker/dockerfiles
* runs the newly built image and starts jetty within the container