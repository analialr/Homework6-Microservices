package com.ironhack.salesrepservice.controller.impl;

import com.ironhack.salesrepservice.controller.interfaces.SalesRepController;
import com.ironhack.salesrepservice.model.SalesRep;
import com.ironhack.salesrepservice.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalesRepControllerImpl implements SalesRepController {

    @Autowired
    public SalesRepRepository salesRepRepository;

    @GetMapping("/salesreps")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesRep> findAll() {
        return salesRepRepository.findAll();
    }

    @GetMapping("/salesreps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalesRep findById(@PathVariable Long id) {
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(id);
        return  optionalSalesRep.get();
    }

    @PostMapping("/salesreps")
    @ResponseStatus(HttpStatus.CREATED)
    public SalesRep create(@RequestBody SalesRep opportunity) {
        return salesRepRepository.save(opportunity);
    }

    @DeleteMapping("/salesreps/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        salesRepRepository.delete(salesRepRepository.findById(id).get());
    }

}
