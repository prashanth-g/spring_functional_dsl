package com.prashanth.spring.functional.dsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringFunctionalDSL {

  public static void main(String[] args) {
    SpringApplication.run(SpringFunctionalDSL.class, args);
  }

  @Bean
  RouterFunction<ServerResponse> routes(PersonService personService) {
    return RouterFunctions.route().GET("/people",
        request -> ServerResponse.ok().syncBody(personService.all())).build();
  }

}

