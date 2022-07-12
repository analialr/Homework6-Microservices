package com.ironhack.opportunityservice.controller.impl;

import com.ironhack.opportunityservice.controller.interfaces.OpportunityController;
import com.ironhack.opportunityservice.models.Opportunity;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OpportunityControllerImpl implements OpportunityController {

    @Autowired
    public OpportunityRepository opportunityRepository;

    @GetMapping("/opportunities")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> findAll() {
        return opportunityRepository.findAll();
    }

    @GetMapping("/opportunities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Opportunity findById(@PathVariable Long id) {
        Optional<Opportunity> optionalOpportunity= opportunityRepository.findById(id);
        return  optionalOpportunity.get();
    }

    @PostMapping("/opportunities")
    @ResponseStatus(HttpStatus.CREATED)
    public Opportunity create(@RequestBody Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }


    @DeleteMapping("/opportunities/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) {
        opportunityRepository.delete(opportunityRepository.findById(id).get());
    }

    // QUERIES BY PRODUCT //
    @GetMapping("/count-opp-by-product")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> countOpportunitiesByProduct() {
        return opportunityRepository.countOpportunitiesByProduct();
    }
    @GetMapping("/count-opp-by-product-closed-won")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> countOpportunitiesByProductAndStatusCLOSED_WON() {
        return opportunityRepository.countOpportunitiesByProductAndStatusCLOSED_WON();
    }
    @GetMapping("/count-opp-by-product-closed-lost")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> countOpportunitiesByProductAndStatusCLOSED_LOST() {
        return opportunityRepository.countOpportunitiesByProductAndStatusCLOSED_LOST();
    }
    @GetMapping("/count-opp-by-product-open")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> countOpportunitiesByProductAndStatusOPEN() {
        return opportunityRepository.countOpportunitiesByProductAndStatusOPEN();
    }

    // QUANTITY STATES QUERIES //
    @GetMapping("/mean-product-quantity")
    @ResponseStatus(HttpStatus.OK)
    public Double findMeanProductQuantity() {
        return opportunityRepository.findMeanProductQuantity().get();
    }

    @GetMapping("/max-product-quantity")
    @ResponseStatus(HttpStatus.OK)
    public Integer findMaxProductQuantity() {
        return opportunityRepository.findMaxProductQuantity().get();
    }

    @GetMapping("/min-product-quantity")
    @ResponseStatus(HttpStatus.OK)
    public Integer findMinProductQuantity() {
        return opportunityRepository.findMinProductQuantity().get();
    }

}
