

##  Docker Files

### Build and Run a docker image using Dockerfile
 
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

### Running a python project with a docker file
create a project 
/docker/helloworld.py
```
import numpy py
print("sin value{}" format)
Create a docker file with the name Dockerfile

- Adding a python package:
```
      FROM python:3
      RUN pip3 install numpy
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTExOTExNDc1MywtMTY1NjA2NDY2NV19
-->