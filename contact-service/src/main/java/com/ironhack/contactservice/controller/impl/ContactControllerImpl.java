package com.ironhack.contactservice.controller.impl;

import com.ironhack.contactservice.controller.interfaces.ContactController;
import com.ironhack.contactservice.models.Contact;
import com.ironhack.contactservice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactControllerImpl implements ContactController {
    @Autowired
    public ContactRepository contactRepository;

    @GetMapping("/contacts")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @GetMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact findById(@PathVariable Long id) {
        Optional<Contact> optionalContact= contactRepository.findById(id);
        return  optionalContact.get();
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact create(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @DeleteMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        contactRepository.delete(contactRepository.findById(id).get());
    }

    @Override
    public List<Contact> findByAccount(Long id) {
        return contactRepository.findByAccount(id);
    }
}
