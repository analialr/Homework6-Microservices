package com.ironhack.edgeservice.Client;

import com.ironhack.edgeservice.Classes.Lead;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("lead-service")
public interface LeadServiceClient {

    @GetMapping("/leads")
    public List<Lead> findAll();

    @GetMapping("/leads/{id}")
    public Lead findById(@PathVariable Long id);

    @PostMapping("/leads")
    public Lead create(@RequestBody Lead lead);

    @DeleteMapping("/leads/{id}")
    public void delete(@PathVariable Long id);

}
