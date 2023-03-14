gradle clean shadowJar
docker rm -f versionsartifact-container
docker rmi -f spectre27/versionsartifact-image
docker build -t spectre27/versionsartifact-image -f src/main/docker/Dockerfile .
docker run --name versionsartifact-container -p 9091:8080 -d spectre27/versionsartifact-image
echo "Docker container versionsartifact-container started"
