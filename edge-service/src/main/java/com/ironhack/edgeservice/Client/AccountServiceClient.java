package com.ironhack.edgeservice.Client;

import com.ironhack.edgeservice.Classes.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("account-service")
public interface AccountServiceClient {

    @GetMapping("/accounts")
    public List<Account> findAll();

    @GetMapping("/accounts/{id}")
    public Account findById(@PathVariable Long id);

    @PostMapping("/accounts")
    public Account create(@RequestBody Account contact);

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable Long id);

}
