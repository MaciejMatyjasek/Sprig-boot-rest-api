package pl.maciej.matyjasek.project.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maciej.matyjasek.project.rest.domain.Person;
import pl.maciej.matyjasek.project.rest.service.PersonService;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("person")
@AllArgsConstructor
public class PersonController {

    PersonService personService;

    @PostMapping
    public ResponseEntity<String> create(@Valid Person validatePerson, @RequestBody Person person) {

        personService.addPerson(person);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("update/{id}")
    public HttpEntity<?> update(@Valid Person validatePerson, @PathVariable Long id,
                                @RequestBody Person person) {

        personService.updatePerson(id, person);

        return ResponseEntity
                .ok()
                .build();
    }


    @GetMapping("get/{id}")
    public HttpEntity<?> getPerson(@PathVariable Long id) {

        Optional<Person> person = personService.getPerson(id);

        return ResponseEntity
                .ok(person);
    }

    @GetMapping("/getAll")
    public Set<Person> getAll() {
        return personService.getAllPersons();
    }

    @PostMapping("/addAll")
    public ResponseEntity<String> addAll(@RequestBody Set<Person> persons) {

        personService.addAllPersons(persons);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();

    }

}
