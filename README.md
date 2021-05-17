Running on local machine
------------------------------------------------------------------------------
- Run a mysql 8.x instance
```shell
docker run \
    --rm \
    -it \
    -p 3306:3306 \
    -e MYSQL_DATABASE=amirdb \
    -e MYSQL_USER=amir \
    -e MYSQL_PASSWORD=Ab#77886951 \
    -e MYSQL_ROOT_PASSWORD=root \
    mysql:8.0.25
```
- Run project
```shell
mvn spring-boot:run
```