#!/bin/bash
./gradlew clean shadowJar
docker build -t spectre27/jersey-spring -f docker/Dockerfile.docker .
# docker run -p 8080:8080 spectre27/jersey-spring