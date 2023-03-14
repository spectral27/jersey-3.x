gradle clean shadowJar

docker rmi -f spectre27/versionsartifact-image-pod
docker build -t spectre27/versionsartifact-image-pod -f src/main/kubernetes/Dockerfile .
docker push spectre27/versionsartifact-image-pod

kubectl delete service versionsartifact-service
kubectl delete deployment versionsartifact-deployment
kubectl apply -f src/main/kubernetes/v1-dns.yaml
kubectl apply -f src/main/kubernetes/v2-deployment.yaml
kubectl apply -f src/main/kubernetes/v3-service.yaml
kubectl get services
