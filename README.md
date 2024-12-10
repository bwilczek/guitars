Very simple Java Spring Boot project. Nothing to see here.

```shell
# start postgres
docker compose up -d

# drop and create DB schema
mvn liquibase:dropAll
mvn liquibase:update

# start app
mvn spring-boot:run

# check that it works
curl localhost:8080/api/guitars
# should return empty collection

# add an entry
curl -X POST -H "Content-Type: application/json" -d '{"brand": "Jolana", "model": "Vikomt", "year_of_production": 1974, "description": "Frets need to be replaced"}' http://localhost:8080/api/guitars

# check that it's there
curl localhost:8080/api/guitars/1
```
