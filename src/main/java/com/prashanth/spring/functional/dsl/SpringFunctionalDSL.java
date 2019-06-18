package com.prashanth.spring.functional.dsl;

import java.net.URI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringFunctionalDSL {

  public static void main(String[] args) {
    SpringApplication.run(SpringFunctionalDSL.class, args);
  }

  @Bean
  RouterFunction<ServerResponse> routes(PersonService personService, PersonHandler personHandler) {
    return RouterFunctions.route()
        .GET("/people", personHandler::handleGetAllReservations)
        .GET("/people/{id}", personHandler::handleGetReservationsById)
        .POST("/people", request -> {
          Mono<Person> person = request.bodyToMono(Person.class);
          String name = person.block().getName();
          Person savedPerson = personService.save(new Person(null, name));
          URI uri = URI.create("/people/" + savedPerson.getId());
          return ServerResponse.created(uri).syncBody(savedPerson);
        })
        .build();
  }

}

