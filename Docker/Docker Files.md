

##  Docker Files

Create a docker file with the name Dockerfile

- Adding a python package:

      FROM python:3
      RUN pip3 install numpy
----
- Building a docker file and creating a image py_numpy
docker build -t py_numpy .
  
- Having  some fun with ubuntu:
`FROM ubuntu:latest
RUN apt-get update && apr-get -y install fortune co`
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE4NTE3Mzk0NjBdfQ==
-->