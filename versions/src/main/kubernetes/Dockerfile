FROM eclipse-temurin:17
COPY build/libs/versions-1.0.0-all.jar run.jar
COPY versions.json versions.json
ENTRYPOINT ["java", "-jar", "-Dorigin=K", "/run.jar"]
