

##  Docker Files

### Anatomy of a Dockerfile
A dockerfile contains all the steps that are required to create an image and would usually be contained within the root directory of the source code repository of an application. 

A typical Dockerfile might look something like the one shown here. 
```
	FROM tomcat:jre8-alpine
	LABEL "mainainer"="rajasekar.vadivelu@gmail.com"
	# For wget to work
	RUN   apk update \                                                                                                                                                                                                                        
	&&   apk add ca-certificates wget \                                                                                                                                                                                                      
	&&   update-ca-certificates 
	# Copy tomcat server.xml
	WORKDIR /usr/local/tomcat
	# Start tomcat
	CMD ["catalina.sh", "run"]
```

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
eyJoaXN0b3J5IjpbMjA0OTMwMjAzMiwtMTc0NzE4MDczOCwyNT
Y5NzgxNTQsLTE2NTYwNjQ2NjVdfQ==
-->