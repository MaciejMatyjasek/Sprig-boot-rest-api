package pl.maciej.matyjasek.project.rest.repository;

import org.springframework.data.repository.Repository;
import pl.maciej.matyjasek.project.rest.domain.Person;

import java.util.Optional;
import java.util.Set;

public interface PersonRepository extends Repository<Person, Long> {

    Optional<Person> saveAndFlush(Person person);

    Optional<Person> findOneById(Long id);

    Set<Person> findAll();

    void deleteById(Long id);
}
