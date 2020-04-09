

##  Docker Files

Create a docker file with the name Dockerfile

- Adding a python package:
```
      FROM python:3
      RUN pip3 install numpy
```

### Building a docker file and creating a image py_numpy
docker build -t  <image_name> <docker filePath>
  
- Having  some fun with ubuntu:

```
	FROM ubuntu:latest 
	RUN apt-get update && apt-get -y install fortune cowsay 
	CMD /usr/games/fortune | /usr/games/cowsay
```
### Docker files more
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTg3MTQzMzg5MywtMTY1NjA2NDY2NV19
-->