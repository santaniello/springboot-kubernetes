#!/bin/bash

VERSION=$1
CONTAINER_NAME=springboot-kubernetes

echo "Update deployment.yaml File............"

sed -i -e "s/\(image: \).*/\1$CONTAINER_NAME:$VERSION/"  ./kustomize/base/deployment.yaml

kubectl delete  deployment $CONTAINER_NAME

kubectl delete  service $CONTAINER_NAME

kubectl delete  configmap $CONTAINER_NAME

eval $(minikube docker-env)

docker build -t $CONTAINER_NAME:$VERSION .

kubectl apply -k kustomize/base/


