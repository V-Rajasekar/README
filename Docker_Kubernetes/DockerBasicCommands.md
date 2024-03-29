# Basic uses of docker

##  Most important commands

- docker container
- docker image
- docker run

Docker image |description
---------|----------
`docker build -t <image name>` .` | creates a docker image 
 `docker images` (or) `docker image ls` | List all images
 `docker rmi <imageId>` | Remove images
 `docker run -p port:bindingPort <imageId> or <image name>` | creating and running a container
 `docker rmi $(docker images -q)` | Remove all images
 `docker search -f STARS=3 Redis` | Search a Redis docker image with star >= 3
 `docker pull mongo` | pull a docker mongo image from DockerHub
 `docker push <image>` | pushing a docker image to DockerHub 


Docker Container | Description
---------|----------
 `docker ps` | List all running container 
 `docker ps -a` | List all container irrespective their state. 
 `docker stop <ContainerId>` |Stop a container
 `docker start <ContainerId>` |Start a container
 `docker rm <ContainerId>` | Remove a container
 `docker stop $(docker ps -a -q)` | Stop a  ll container
 `docker rm $(docker ps -a -q)` | Remove all container
 `docker logs  <friendly name (or) container-id>` | prints the docker startup logs
 `docker inspect <friendly name (or) container-id>` | more details IP Address, Volumn mounted and its locations and current execution status.
>Note: you can also do `docker container ls/ps`, `docker container ps -a` and `docker image ls`


Docker compose | description
---------|----------
 `docker-compose build` |  building a docker compose
 `docker-compose up -d <serviceName>` | run

## Running docker container

To start a container either build your own docker image or use existing image created by docker community available in

[https://registry.hub.docker.com/](https://registry.hub.docker.com/)

`docker run Redis`

####   Searching an image
`edocker search --filter=start=3 Redis  # Show all Redis images starting with 3 stars`
#### List running containers

`docker image ls`

`docker container ls/ps`

`docker inspect <friendly name |container-id>` # more details IP Address, Volumn mounted and its locations and current execution status.

`docker logs  <friendly name |container-id>` # prints the docker startup logs

#### List containers irrespective of its current status

`docker container ls -a`

#### Run the helloworld image

`docker run hello-world`

#### Run a basic Python file

`docker run -v $(pwd):/src --rm python :3 \
python /src/hello-world.py`

#### Removing/stopping a  container

`docker container stop/rm <container-Id/name>`

#### Removing all containers:

`docker container rm $(docker ps -a -q)`

#### Running the python interpreter:

`docker run -it --rm python:3`

#### Running the Base shell

`docker run -it --rm python:3
/bin/bash`

#### Running the Node

`docker run -it --rm node:latest /bin/bash`

#### Binding ports

Each container is sandboxed from other container. If a service needs to accessed externally, then need to be expose a port

to be mapped to the host. This can be done in the container start using the option -p <host port>:<container port>

`docker run -p 6379:6379 run redis` # The Redis container exposes the services in port 6379.

`docker run -d -p 6379 redis`  # Docker assigns random port if no host port is given. This allows to run

multiple instances of the same service on

#### Binding directories

Container are stateless. Any data we want to persist after a container is stopped should be saved to the host machine. This is done by

mounting/binding host directories into the container. when the directory is mounted the files in the directory can be accessed by the container

Any change/written to the directory inside the container will be stored on the host. This allows to change/upgrade the container without

losing your data.

option: -v <host-dir>:<container-dir>

#### Running container in background and foreground
##### Run container and start a bash prompt
`docker run -it ubuntu /bin/bash` 

`docker run ubuntu ps`

`docker run -d redis` # run in detached mode.

### Running Softwares

#### Running a Mysql Container

`docker run --rm -d --name my_mysql -e 
MYSQL_ROOT_PASSWORD=spme-pwd mysql:latest`

#### Logging into the container and into the mysql console

`docker exec -it my_mysql mysql -h localhost -u root -p`

#### Running an Nginx Container serving some html

`docker run -d -v $(pwd):/usr/share/nginx/html -p 80:80 --name my_nginx nginx:latest`

#### Logging into the container and looking around using bash

`docker exec -it my_nginx /bin/bash`

#### Tagging Docker images 
`docker tag springboot-docker:1.0.0 rajasekardocker/springboot-docker:1.0.0`

#### Pushing Docker images to remote(Docker hub)

Login to your dockerhub repo

```
docker login
Username:
password

docker push rajasekardocker/springboot-docker:1.0.0
```

