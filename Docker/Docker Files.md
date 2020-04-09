

##  Docker Files

### Build and Run a docker image using Dockerfile
docker build -t  <image_name> <Dockerfile_path>
  
- Having  some fun with ubuntu:
##### Dockerfile
```
	FROM ubuntu:latest 
	RUN apt-get update && apt-get -y install fortune cowsay 
	CMD /usr/games/fortune | /usr/games/cowsay
```
##### Building the docker image
`docker build -t ubuntu_fun .`

#####  Running the docker image.
`docker run --rm ubuntu_fun`

### Docker files more
<!--stackedit_data:
eyJoaXN0b3J5IjpbMjA1MDg2MzU4MSwtMTY1NjA2NDY2NV19
-->