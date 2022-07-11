package com.ironhack.opportunityservice.controller.impl;

import com.ironhack.opportunityservice.controller.interfaces.OpportunityController;
import com.ironhack.opportunityservice.models.Opportunity;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OpportunityControllerImpl implements OpportunityController {

    @Autowired
    public OpportunityRepository opportunityRepository;

    public List<Opportunity> findAll() {
        return opportunityRepository.findAll();
    }


    public Opportunity findById(@PathVariable Long id) {
        Optional<Opportunity> optionalOpportunity= opportunityRepository.findById(id);
        return  optionalOpportunity.get();
    }


    public Opportunity create(@RequestBody Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }


    public void delete(Long id) {
        opportunityRepository.delete(opportunityRepository.findById(id).get());
    }
}
