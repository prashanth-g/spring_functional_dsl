package com.prashanth.spring.functional.dsl;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class SpringFunctionalDSL {

  public static void main(String[] args) {
    SpringApplication.run(SpringFunctionalDSL.class, args);
  }

  @Bean
  RouterFunction<ServerResponse> routes(PersonService personService) {
    return route().GET("/people",
        serverRequest -> ServerResponse.ok().syncBody(personService.all()))
        .build();
  }
}

