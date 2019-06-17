package com.prashanth.spring.functional.dsl;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class PersonHandler {

  private final PersonService personService;

  public PersonHandler(
      PersonService personService) {
    this.personService = personService;
  }

  ServerResponse handleGetAllReservations(ServerRequest serverRequest) {
    return null;
  }

  ServerResponse handleGetReservationsById(ServerRequest serverRequest) {
    return null;
  }
}
