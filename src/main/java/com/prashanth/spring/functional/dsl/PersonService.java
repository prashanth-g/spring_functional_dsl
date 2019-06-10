package com.prashanth.spring.functional.dsl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PersonService {

  private final Set<Person> people = new HashSet<>(
      Arrays.asList(new Person(1L, "Sachin"), new Person(2L, "Sehwag"),
          new Person(3L, "Ganguly")));

  Set<Person> all() {
    return this.people;
  }

  Person byId(Long id) {
    return this.people.stream().filter(person -> person.getId().equals(id))
        .findFirst().orElseThrow(() -> new IllegalArgumentException(
            "no " + Person.class.getName() + " with the id found"));
  }
}

