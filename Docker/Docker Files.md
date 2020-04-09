

##  Docker Files

Create a docker file with the name Dockerfile

- Adding a python package:
```
      FROM python:3
      RUN pip3 install numpy
```

### Building a docker file and creating a image py_numpy
docker build -t  <image_name> <Dockerfile_path>
  
- Having  some fun with ubuntu:
##### Dock
```
	FROM ubuntu:latest 
	RUN apt-get update && apt-get -y install fortune cowsay 
	CMD /usr/games/fortune | /usr/games/cowsay
```

`docker build -t ubuntu_fun .`

`docker run --rm ubuntu_fun`
### Docker files more
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTkxMjAxMjA1NywtMTY1NjA2NDY2NV19
-->