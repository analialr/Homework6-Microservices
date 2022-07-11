package com.ironhack.leadcontactserver.controller.impl;

import com.ironhack.leadcontactserver.controller.interfaces.ContactController;
import com.ironhack.leadcontactserver.models.Contact;
import com.ironhack.leadcontactserver.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactControllerImpl implements ContactController {
    @Autowired
    public ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }


    public Contact findById(@PathVariable Long id) {
        Optional<Contact> optionalContact= contactRepository.findById(id);
        return  optionalContact.get();
    }


    public Contact create(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }


    public void delete(Long id) {
        contactRepository.delete(contactRepository.findById(id).get());
    }
}
