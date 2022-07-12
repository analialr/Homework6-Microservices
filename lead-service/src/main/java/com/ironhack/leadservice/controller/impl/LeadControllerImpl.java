package com.ironhack.leadservice.controller.impl;

import com.ironhack.leadservice.controller.interfaces.LeadController;
import com.ironhack.leadservice.models.Lead;
import com.ironhack.leadservice.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LeadControllerImpl implements LeadController {

    @Autowired
    public LeadRepository leadRepository;

    @GetMapping("/leads")
    @ResponseStatus(HttpStatus.OK)
    public List<Lead> findAll() {
        return leadRepository.findAll();
    }


    @GetMapping("/leads/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lead findById(@PathVariable Long id) {
        Optional<Lead> optionalLead= leadRepository.findById(id);
        return  optionalLead.get();
    }

    @PostMapping("/leads")
    @ResponseStatus(HttpStatus.CREATED)
    public Lead create(@RequestBody Lead lead) {
        return leadRepository.save(lead);
    }


    @DeleteMapping("/leads/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) {
        leadRepository.delete(leadRepository.findById(id).get());
    }
}
