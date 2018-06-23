package pl.maciej.matyjasek.project.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maciej.matyjasek.project.rest.domain.Contact;
import pl.maciej.matyjasek.project.rest.service.ContactService;
import pl.maciej.matyjasek.project.rest.service.PersonService;

import java.util.Set;

@RestController
@RequestMapping("contact")
@AllArgsConstructor
public class ContactController {

    PersonService personService;
    ContactService contactService;

    @PostMapping("add")
    public ResponseEntity<String> create(@RequestBody Contact contact) {

        contactService.addContactForPerson(contact);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("update/{id}")
    public HttpEntity<?> updateContactForPerson(@PathVariable Long id,
                                @RequestBody Contact contact) {

        contactService.updateContact(id, contact);

        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("get/{personId}")
    public Set<Contact> getContactsForPerson(@PathVariable Long personId) {

        return contactService.getContactsByPersonId(personId);

    }

//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<String> delete(@PathVariable Long id){
//
//        contactService.delete(id);
//
//        return ResponseEntity.status(HttpStatus.GONE).build();
//    }

//    @GetMapping("/getAll")
//    public Set<Person> getAll() {
//        return personService.getAllPersons();
//    }
//
//    @PostMapping("/addAll")
//    public ResponseEntity<String> addAll(@RequestBody Set<Person> persons) {
//
//        personService.addAllPersons(persons);
//
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .build();
//
//    }

}
