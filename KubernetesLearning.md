## Kubernetes
- Architecture type is Client/Server 
      
      [2 Nodes -> 1 Master, 1 worker Node] -> Kubernetes Cluster
            Worker Node/Pod -> Docker Desktop + Kublet

       Worker -> Docker Container Runs
          -> Docker Desktop/Docker Engine/Docker Daemon
          -> Kublet interacts with Master and report the health of the Node
       Master
         - Controller -> Kublet (Interacts with Kublet to deploy containers Worker Node)
         - Scheduler -> Decides how and when the instances to be deployed
         - API Server -> Interacts with outsode world
           - kubectl - Kube control commands   
         - etcd -> Database used by Master

How to create a Cluster in Local ? 
  - minikube is a Development software it's ment only for development purpose and for production
    -  Install MiniKube
    -  Create Kunernetes cluster with below command
    >  minikube start 
    - MiniKube team basically combined Master & Worker Node so a single node is available for development purpose
    - Shows list of services running in the 
    > kubectl get services 
    > kubectl create deployment <Deployment name> --image=<Docker login username>/<Docker Image name>
    > kubectl get pods
    Basically docker pull <Image Name> - > Download the image from docker hub website.
    > kubectl edit deployment <Deployment Name> -> change the replica nos
  - How to access the application outside the pod ? 
    -  Add EXPOSE <Port>8080 in Dockerfile
    -  Create a service
       -  LoadBalance
            > kubectl expose deployment <Deployment Name> --type=LoadBalancer --port=8080
            > kubectl get services
            > minikube tunnel # To get the external-id
       - NodePort
  - How to see the Kuberneteus dashboard 
    > minikube dashboard 127.0.0.1/61181
  - Create a Application with Dockerfile
  - Build your project
  - docker build -t <Image name>:<version>
  - docker --login <userName> <Password>
  - docker images 
  - docker tag <Docker image> <docker login name>/<ImageName>   
  - docker push <docker login name>/<Image name>


Deploying a POD in Kubernetes
Kube + Docker
 -> DevOps -> Developer -> How this application has to be created
 DevOps -> Kube/K8/Kubernetes Cluster
 Dev -> Write YAML-> How to create application/how to expose it
 YAML ->  apiversion, kind, metadata, spec
 kubectl create deployment --name=backend-depl --image=tomcat8.1

Create a Kubernetes deployment file <db-deployment.yml>
Create a pod and deploy in kuberneteus cluster
> kubectl apply -f db-deployment.yml
> kubectl get pods
> kubectl get services
> kubectl describe pod <PodId> to troubleshoot on a pod
> kubectl exec -it <Podid> /bin/sh # To login to the container
> mysql -u root -p # To connect to the database

#Create a Kubernetes service to access the Pod. Service is needed to 
expose the service outside the world and within the Cluster
- Create a file name service <db-service.yml> 
> kubectl delete service <service name>
> kubectl apply -f db-service.yml
> kubectl get svc
> kubectl log -f <PodId> to follow through 

To tunnel kuberneteus cluster nodes and access it locally run
> minikube tunnel
- sql connectionstring jdbc:mysql:default.svc.cluster.local:3306
minikube dashboard

Sample project
[kubernetes-with-minikube.demo](https://github.com/iamvickyav/kubernetes-with-minikube-demo)