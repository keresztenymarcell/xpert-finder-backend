#!/bin/zsh
mvn clean install
docker build -f Dockerfile -t expert-finder .

docker run \
    -e JDBC_DATABASE_USERNAME='keresztenymarcell' \
    -e JDBC_DATABASE_PASSWORD='Macska4123' \
    -e JDBC_DATABASE_URL='jdbc:postgresql://localhost:5432/proyecte_grande' \
    -p 8080:8080 \
     expert-finder

