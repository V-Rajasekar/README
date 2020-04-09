

##  Docker Files

Create a docker file with the name Dockerfile

- Adding a python package:

      FROM python:3
      RUN pip3 install numpy
----
- Building a docker file and creating a image py_numpy
docker build -t py_numpy .
  
- Having  some fun with ubuntu:
// A code block
var foo ='bar';
	`FROM ubuntu:latest 
	RUN apt-get update && apt-get -y install fortune cowsay 
	CMD /usr/games/fortune | /usr/games/cowsay`
----

<!--stackedit_data:
eyJoaXN0b3J5IjpbODczNDkxMzE2LC0xNjU2MDY0NjY1XX0=
-->