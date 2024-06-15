https://www.datacamp.com/tutorial/set-up-and-configure-mysql-in-docker

#Pull and Start Mysql Docker
```
$ docker pull mysql:latest
$ docker run -d --name test-mysql -e MYSQL_ROOT_PASSWORD=password -p 3307:3306 mysql
$ docker exec -it container_name bash
```

#Preserve the Data Stored in the MySQL Docker Container
```
$ docker volume create test-mysql-data
$ docker stop test-mysql; docker rm test-mysql
$ docker run \
   --name test-mysql \
   -v test-mysql-data:/var/lib/mysql \
   -e MYSQL_ROOT_PASSWORD=strong_password \
   -d mysql
```

#To Stop and remove the containter
```
$ docker stop test-mysql; docker rm test-mysql
$ docker volume rm test-mysql-data
```

