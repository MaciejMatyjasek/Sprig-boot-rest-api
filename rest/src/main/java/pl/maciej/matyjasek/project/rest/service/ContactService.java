package pl.maciej.matyjasek.project.rest.service;

import pl.maciej.matyjasek.project.rest.domain.Contact;

import java.util.Optional;
import java.util.Set;

public interface ContactService {
    void addContactForPerson(Contact contact);

    Contact updateContact(Long id, Contact contact);

    Optional<Contact> getContactByPerson(Long personId);

    Set<Contact> getContactsByPersonId(Long personId);

//    void delete(Long id);
}
