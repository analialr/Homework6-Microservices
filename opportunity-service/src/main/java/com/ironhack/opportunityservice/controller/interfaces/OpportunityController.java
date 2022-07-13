package com.ironhack.opportunityservice.controller.interfaces;

import com.ironhack.opportunityservice.models.Opportunity;

import java.util.List;

public interface OpportunityController {
    List<Opportunity> findAll();
    Opportunity findById(Long id);
    Opportunity create(Opportunity opportunity);
    void delete(Long id);

    // QUERIES BY PRODUCT //
    List<Object[] >  countOpportunitiesByProduct();
    List<Object[] > countOpportunitiesByProductAndStatusCLOSED_WON();
    List<Object[] > countOpportunitiesByProductAndStatusCLOSED_LOST();
    List<Object[] > countOpportunitiesByProductAndStatusOPEN();

    // QUANTITY STATES QUERIES //
    Double findMeanProductQuantity();
    Integer findMaxProductQuantity();
    Integer findMinProductQuantity();

}

