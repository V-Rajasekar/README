---


---

<h1 id="basic-uses-of-docker">Basic uses of docker</h1>
<h2 id="most-important-commands">Most important commands:</h2>
<ul>
<li>docker container</li>
<li>docker image</li>
<li>docker run</li>
</ul>
<h2 id="running-docker-container">Running docker container</h2>
<p>To start a container either build your own docker image or use existing image created by docker community available in</p>
<p><a href="https://registry.hub.docker.com/">https://registry.hub.docker.com/</a></p>
<p>docker run Redis</p>
<h4 id="searching-an-image">Searching an image</h4>
<p><code>edocker search --filter=start=3 Redis # Show all Redis images starting with 3 stars</code></p>
<h4 id="list-running-containers">List running containers</h4>
<p><code>docker image ls</code></p>
<p><code>docker container ls/ps</code></p>
<p><code>docker inspect &lt;friendly name |container-id&gt;</code> # more details IP Address, Volumn mounted and its locations and current execution status.</p>
<p><code>docker logs &lt;friendly name |container-id&gt;</code> # prints the docker startup logs</p>
<h4 id="list-containers-irrespective-of-its-current-status">List containers irrespective of its current status</h4>
<p><code>docker container ls -a</code></p>
<h4 id="run-the-helloworld-image">Run the helloworld image</h4>
<p><code>docker run hello-world</code></p>
<h4 id="run-a-basic-python-file">Run a basic Python file</h4>
<p><code>docker run -v $(pwd):/src --rm python :3 \ python /src/hello-world.py</code></p>
<h4 id="removingstopping-a--container">Removing/stopping a  container</h4>
<p><code>docker container stop/rm &lt;container-Id/name&gt;</code></p>
<h4 id="removing-all-containers">Removing all containers:</h4>
<p><code>docker container rm $(docker ps -a -q)</code></p>
<h4 id="running-the-python-interpreter">Running the python interpreter:</h4>
<p><code>docker run -it --rm python:3</code></p>
<h4 id="running-the-base-shell">Running the Base shell</h4>
<p><code>docker run -it --rm python:3 /bin/bash</code></p>
<h4 id="running-the-node">Running the Node</h4>
<p><code>docker run -it --rm node:latest /bin/bash</code></p>
<h4 id="binding-ports">Binding ports</h4>
<p>Each container is sandboxed from other container. If a service needs to accessed externally, then need to be expose a port</p>
<p>to be mapped to the host. This can be done in the container start using the option -p :</p>
<p><code>docker run -p 6379:6379 run redis</code> # The Redis container exposes the services in port 6379.</p>
<p><code>docker run -d -p 6379 redis</code>  # Docker assigns random port if no host port is given. This allows to run</p>
<p>multiple instances of the same service on</p>
<h4 id="binding-directories">Binding directories</h4>
<p>Container are stateless. Any data we want to persist after a container is stopped should be saved to the host machine. This is done by</p>
<p>mounting/binding host directories into the container. when the directory is mounted the files in the directory can be accessed by the container</p>
<p>Any change/written to the directory inside the container will be stored on the host. This allows to change/upgrade the container without</p>
<p>losing your data.</p>
<p>option: -v :</p>
<p>####Running container in background and foreground</p>
<p><code>docker run -it ubuntu /bin/bash</code> # run container and start a bash prompt.</p>
<p><code>docker run ubuntu ps</code></p>
<p><code>docker run -d redis</code> # run in detached mode.</p>
<h3 id="running-softwares">Running Softwares</h3>
<h4 id="running-a-mysql-container">Running a Mysql Container</h4>
<p>`docker run --rm -d --name my_mysql \</p>
<p>-e MYSQL_ROOT_PASSWORD=spme-pwd \</p>
<p>mysql:latest`</p>
<h4 id="logging-into-the-container-and-into-the-mysql-console">Logging into the container and into the mysql console</h4>
<p><code>docker exec -it my_mysql \ mysql -h localhost -u root -p</code></p>
<h4 id="running-an-nginx-container-serving-some-html">Running an Nginx Container serving some html</h4>
<p><code>docker run -d -v $(pwd):/usr/share/nginx/html -p 80:80 --name my_nginx nginx:latest</code></p>
<h4 id="logging-into-the-container-and-looking-around-using-bash">Logging into the container and looking around using bash</h4>
<p><code>docker exec -it my_nginx /bin/bash</code></p>

