#! /bin/sh
./mvnw package
docker build -t mra9776/dockerBike .
docker-compose run -p 8080:8080 mra9776_c1 --build