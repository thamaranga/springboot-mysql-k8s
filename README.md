# springboot-mysql-k8s
This is a sample spring boot rest api which is deployed  in a local kubernates cluster (minikube)

Starting the minikube kubernates cluster
minikuber start

Inside the project, kubernates folder contains all the yaml files  related to creating configmaps,
creating secrets, creating deployments and services.
(It is better if you are not included secrets related yaml files public when concerning security aspect)

Creating configmap containing db information
kubectl apply -f mysql-configmap.yaml

Creating secret containing mysql root password
kubectl apply -f mysql-root-secret.yaml

Creating secret containing  mysql username and password
kubectl apply -f mysql-user-secret.yaml

Mysql deployment
kubectl apply -f mysql-deployment.yaml

spring boot jar file need to build using maven. 
mvn clean install -DskipTests -> Build the jar file skipping auto test run

Create the docker image from above jar file
docker image build -t hasitha1990/students-app:1.0 .

Deploy spring boot application
kubectl apply -f spring-deployment.yaml

Run the application using the url returned by below command
minikube service students-app --url
