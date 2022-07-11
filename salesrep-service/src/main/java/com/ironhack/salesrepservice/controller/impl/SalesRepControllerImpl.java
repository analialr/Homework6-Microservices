package com.ironhack.salesrepservice.controller.impl;

import com.ironhack.salesrepservice.controller.interfaces.SalesRepController;
import com.ironhack.salesrepservice.model.SalesRep;
import com.ironhack.salesrepservice.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SalesRepControllerImpl implements SalesRepController {

    @Autowired
    public SalesRepRepository salesRepRepository;

    public List<SalesRep> findAll() {
        return salesRepRepository.findAll();
    }


    public SalesRep findById(@PathVariable Long id) {
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(id);
        return  optionalSalesRep.get();
    }


    public SalesRep create(@RequestBody SalesRep opportunity) {
        return salesRepRepository.save(opportunity);
    }


    public void delete(Long id) {
        salesRepRepository.delete(salesRepRepository.findById(id).get());
    }

}
