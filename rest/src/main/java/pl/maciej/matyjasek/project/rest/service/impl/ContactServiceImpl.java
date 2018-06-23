package pl.maciej.matyjasek.project.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maciej.matyjasek.project.rest.domain.Contact;
import pl.maciej.matyjasek.project.rest.repository.ContactRepository;
import pl.maciej.matyjasek.project.rest.repository.PersonRepository;
import pl.maciej.matyjasek.project.rest.service.ContactService;
import pl.maciej.matyjasek.project.rest.utils.ContactFactory;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {

    private PersonRepository personRepository;
    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(PersonRepository personRepository, ContactRepository contactRepository) {
        this.personRepository = personRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional
    public void addContactForPerson(Contact contact) {


        if (contactRepository.existsById(contact.getId())) {
            System.out.println("already in database");
        }
        contactRepository.saveAndFlush(contact);
    }

    @Override
    public Contact updateContact(@Valid Long personId, Contact updatedContact) {
        Optional<Contact> contact = contactRepository.findOneByPersonId(personId);

        if (!contact.isPresent() && updatedContact == null) {
            System.out.println("both parameters are null");
        } else if (!contact.isPresent() || updatedContact == null) {
            System.out.println("one of parameters is null");
        }
        Contact validUpdatedContact = ContactFactory.updateAndCreateContact(contact.get(), updatedContact);

        return contactRepository.saveAndFlush(validUpdatedContact).get();
    }

    @Override
    public Set<Contact> getContactsByPersonId(Long personId) {

        if (!contactRepository.existsByPersonId(personId)) {
            System.out.println("no person connected to contacts");
        }
        Set<Contact> contactsOfPerson = contactRepository.findAllByPersonIdIn(personId);

        return contactsOfPerson;
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Optional<Contact> getContactByPerson(Long personId) {
        if (!contactRepository.existsByPersonId(personId)) {
            System.out.println("no person connected to contacts");
        }
        return contactRepository.findOneByPersonId(personId);
    }
}
