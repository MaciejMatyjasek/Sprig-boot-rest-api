package pl.maciej.matyjasek.project.rest.repository;

import org.springframework.data.repository.Repository;
import pl.maciej.matyjasek.project.rest.domain.Contact;

import java.util.Optional;
import java.util.Set;

public interface ContactRepository extends Repository<Contact, Long> {

    boolean existsById(Long id);

    Optional<Contact> saveAndFlush(Contact contact);

    Optional<Contact> findOneByPersonId(Long personId);

    boolean existsByPersonId(Long personId);

    Set<Contact> findAllByPersonIdIn(Long personId);

//    Set<Contact> findAllByEmail(String email);

    void deleteById(Long id);

    void deleteByPersonId(Long id);
}
