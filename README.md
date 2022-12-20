Based on Course:
https://www.udemy.com/course/spring-security-zero-to-master/

## Run application using docker
If you want to run the project using docker, first execute a

`mvn clean install -DskipTests`

(skipTests would be required here because it will try to connect into the databases that are not up yet)

Run your containers:

create docker network for the containers
`docker network create springSecurity`

`$ docker-compose up OR $ docker-compose up --build --force-recreate`

Check all containers are up and running:

`$ docker ps`

For stopping our stack:

`$ docker-compose stop`

## keycloak
to access all the keycloak urls, you need to add the following entry to your hosts file:
`http://localhost:8180/realms/bankdev/.well-known/openid-configuration`
