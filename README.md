spring_functional_dsl
=====================

To get list of entities:


  GET:http://localhost:8080/people

Get entity by id

  GET:http://localhost:8080/people/{id}

Save a new entity

  POST:http://localhost:8080/people

  Request body:

  ```json
  {
  	"name":"Bob"
  }
  ```