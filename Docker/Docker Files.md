

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
`docker build -t ubuntu_fun .`[^1]

[^1]: Docker image build syntax `docker build -t <image_name> <Dockerfile_path>`
#####  Running the docker image.
`docker run --rm ubuntu_fun`

### Running a python project with a docker file
##### Python project 
- /docker/helloworld.py
```
import numpy py
print("sin value{}" format(sin(0)))
```
- Dockerfile
```
    # Adding a python package:
      FROM python:3
      RUN pip3 install numpy
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbMjU2OTc4MTU0LC0xNjU2MDY0NjY1XX0=
-->