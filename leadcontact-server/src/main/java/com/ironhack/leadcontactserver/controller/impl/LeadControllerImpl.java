package com.ironhack.leadcontactserver.controller.impl;

import com.ironhack.leadcontactserver.controller.interfaces.LeadController;
import com.ironhack.leadcontactserver.models.Lead;
import com.ironhack.leadcontactserver.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LeadControllerImpl implements LeadController {

    @Autowired
    public LeadRepository leadRepository;

    public List<Lead> findAll() {
        return leadRepository.findAll();
    }


    public Lead findById(@PathVariable Long id) {
        Optional<Lead> optionalLead= leadRepository.findById(id);
        return  optionalLead.get();
    }


    public Lead create(@RequestBody Lead lead) {
        return leadRepository.save(lead);
    }


    public void delete(Long id) {
        leadRepository.delete(leadRepository.findById(id).get());
    }
}
