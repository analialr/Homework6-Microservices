package com.ironhack.edgeservice.Client;

import com.ironhack.edgeservice.Classes.Opportunity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("opportunity-service")
public interface OpportunityServiceClient {

    @GetMapping("/opportunities")
    public List<Opportunity> findAll();
    @GetMapping("/opportunities/{id}")
    public Opportunity findById(@PathVariable Long id);
    @PostMapping("/opportunities")
    public Opportunity create(@RequestBody Opportunity opportunity);
    @DeleteMapping("/opportunities/{id}")
    public void delete(@PathVariable Long id);

    @GetMapping("/mean-product-quantity")
    public Double findMeanProductQuantity();
    @GetMapping("/max-product-quantity")
    public Integer findMaxProductQuantity();
    @GetMapping("/min-product-quantity")
    public Integer findMinProductQuantity();
}
