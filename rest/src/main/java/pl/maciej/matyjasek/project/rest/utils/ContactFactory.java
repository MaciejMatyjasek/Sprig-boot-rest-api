package pl.maciej.matyjasek.project.rest.utils;

import pl.maciej.matyjasek.project.rest.domain.Contact;

public class ContactFactory {

    public static Contact updateAndCreateContact(Contact contact,
                                               Contact updatedContact){

        contact.setEmail(updatedContact.getEmail());
        contact.setTelephoneNumber(updatedContact.getTelephoneNumber());

        return contact;
    }
}
