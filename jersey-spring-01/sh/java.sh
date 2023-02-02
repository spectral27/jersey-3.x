#!/bin/bash
./gradlew clean shadowJar
java -jar -Dorigin=J build/libs/jersey-spring-01-1.0-SNAPSHOT-all.jar
