package com.ironhack.leadcontactserver.controller.interfaces;

import com.ironhack.leadcontactserver.models.Contact;
import com.ironhack.leadcontactserver.models.Lead;

import java.util.List;

public interface ContactController {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact create(Contact contact);
    void delete(Long id);
}
