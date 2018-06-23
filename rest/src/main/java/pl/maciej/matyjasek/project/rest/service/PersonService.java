package pl.maciej.matyjasek.project.rest.service;

import pl.maciej.matyjasek.project.rest.domain.Person;

import java.util.Optional;
import java.util.Set;

public interface PersonService {

    void addPerson(Person person);

    Optional<Person> getPerson(Long id);

    Person updatePerson(Long id, Person updatedPerson);

    Set<Person> getAllPersons();

    void addAllPersons(Set<Person> persons);
}
