package com.prashanth.spring.functional.dsl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final AtomicLong counter = new AtomicLong();

  private final Set<Person> people = new HashSet<>(
      Arrays.asList(new Person(counter.incrementAndGet(), "Sachin"),
          new Person(counter.incrementAndGet(), "Sehwag"),
          new Person(counter.incrementAndGet(), "Ganguly")));

  Set<Person> all() {
    return this.people;
  }

  Person save(Person p) {
    Person person = new Person(counter.incrementAndGet(), p.getName());
    this.people.add(person);
    return person;
  }

  Person byId(Long id) {
    return this.people.stream().filter(person -> person.getId().equals(id))
        .findFirst().orElseThrow(() -> new IllegalArgumentException(
            "no " + Person.class.getName() + " with the id found"));
  }
}

