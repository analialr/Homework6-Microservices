package com.ironhack.contactservice.controller.interfaces;

import com.ironhack.contactservice.models.Contact;

import java.util.List;

public interface ContactController {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact create(Contact contact);
    void delete(Long id);
}
