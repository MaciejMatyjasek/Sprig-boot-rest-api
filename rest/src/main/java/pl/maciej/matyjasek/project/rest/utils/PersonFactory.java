package pl.maciej.matyjasek.project.rest.utils;

import pl.maciej.matyjasek.project.rest.domain.Person;

public class PersonFactory {

    public static Person updateAndCreatePerson(Person person,
                                               Person updatedPerson){

        person.setFirstName(updatedPerson.getFirstName());
        person.setLastName(updatedPerson.getLastName());
        person.setGender(updatedPerson.getGender());
        person.setBirthday(updatedPerson.getBirthday());
        person.setPeselNumber(updatedPerson.getPeselNumber());

        return person;
    }
}
