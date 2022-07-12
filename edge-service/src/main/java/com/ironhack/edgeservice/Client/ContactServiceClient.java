package com.ironhack.edgeservice.Client;


import com.ironhack.edgeservice.Classes.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("contact-service")
public interface ContactServiceClient {
    @GetMapping("/contacts")
    public List<Contact> findAll();

    @GetMapping("/contacts/{id}")
    public Contact findById(@PathVariable Long id);

    @PostMapping("/contacts")
    public Contact create(@RequestBody Contact contact);

    @PostMapping("/contacts/{id}")
    public void delete(@PathVariable Long id);
}
