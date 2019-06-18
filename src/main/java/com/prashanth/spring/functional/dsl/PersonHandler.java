package com.prashanth.spring.functional.dsl;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {

  private final PersonService personService;

  public PersonHandler(
      PersonService personService) {
    this.personService = personService;
  }

  Mono<ServerResponse> handleGetAllReservations(ServerRequest serverRequest) {
    return ServerResponse.ok().syncBody(personService.all());
  }

  Mono<ServerResponse> handleGetReservationsById(ServerRequest serverRequest) {
    return ServerResponse.ok().syncBody(
        personService.byId(Long.parseLong(serverRequest.pathVariable("id"))));
  }
}
