#!/bin/bash
gradle clean shadowJar
docker rm spectre27jerseyspringdocker
docker rmi spectre27/jersey-spring
docker build -t spectre27/jersey-spring -f docker/Dockerfile.docker .
# docker run --name spectre27jerseyspringdocker -p 8080:8080 -d spectre27/jersey-spring
