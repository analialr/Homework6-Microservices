package com.ironhack.edgeservice.Client;

import com.ironhack.edgeservice.Classes.SalesRep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("salesrep-service")
public interface SalesRepServiceClient {

    @GetMapping("/salesreps")
    public List<SalesRep> findAll();

    @GetMapping("/salesreps/{id}")
    public SalesRep findById(@PathVariable Long id);

    @PostMapping("/salesreps")
    public SalesRep create(@RequestBody SalesRep opportunity);

    @DeleteMapping("/salesreps/{id}")
    public void delete(@PathVariable Long id);

}
