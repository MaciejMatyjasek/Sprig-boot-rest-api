package pl.maciej.matyjasek.project.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maciej.matyjasek.project.rest.domain.Person;
import pl.maciej.matyjasek.project.rest.repository.ContactRepository;
import pl.maciej.matyjasek.project.rest.repository.PersonRepository;
import pl.maciej.matyjasek.project.rest.service.PersonService;
import pl.maciej.matyjasek.project.rest.utils.PersonFactory;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private ContactRepository contactRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, ContactRepository contactRepository) {
        this.personRepository = personRepository;
        this.contactRepository = contactRepository;
    }


    @Override
    @Transactional
    public void addPerson(Person person) {
        personRepository.saveAndFlush(person);
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return personRepository.findOneById(id);
    }

    @Override
    public Person updatePerson(Long id, Person updatedPerson) {
        Optional<Person> person = personRepository.findOneById(id);

        if (!person.isPresent() && updatedPerson == null) {
            System.out.println("both parameters are null");
        } else if (!person.isPresent() || updatedPerson == null) {
            System.out.println("one of parameters is null");
        }
        Person validUpdatedPerson = PersonFactory.updateAndCreatePerson(person.get(), updatedPerson);

        return personRepository.saveAndFlush(validUpdatedPerson).get();
    }

    @Override
    public Set<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public void addAllPersons(Set<Person> persons) {
        persons.forEach(this::addPerson);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

//    @Override
//    public Set<Person> getAllPersonsByEmail(String email) {
//
//        Set<Contact> allContactsByEmail = contactRepository.findAllByEmail(email);
//
//        allContactsByEmail.forEach(contact -> contact.getPerson().getId());
//
//
//
//        Set<Person> personsByEmail = personRepository
//                .findAllById(allContactsByEmail
//                        .forEach(contact -> contact.getPerson().getId()));
//
//        return personsByEmail;
//    }
}
