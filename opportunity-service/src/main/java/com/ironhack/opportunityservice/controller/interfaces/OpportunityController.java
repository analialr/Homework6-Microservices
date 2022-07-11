package com.ironhack.opportunityservice.controller.interfaces;

import com.ironhack.opportunityservice.models.Opportunity;

import java.util.List;

public interface OpportunityController {
    List<Opportunity> findAll();
    Opportunity findById(Long id);
    Opportunity create(Opportunity opportunity);
    void delete(Long id);
}
