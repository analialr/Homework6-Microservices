package com.ironhack.accountservice.controller.impl;

import com.ironhack.accountservice.model.Account;
import com.ironhack.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountControllerImpl {
    @Autowired
    public AccountRepository accountRepository;

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account findById(@PathVariable Long id) {
        Optional<Account> optionalContact= accountRepository.findById(id);
        return  optionalContact.get();
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Account contact) {
        return accountRepository.save(contact);
    }

    @DeleteMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) {
        accountRepository.delete(accountRepository.findById(id).get());
    }

    @GetMapping("/account-max")
    @ResponseStatus(HttpStatus.OK)
    public Integer maxEmployeeCount() {
        return accountRepository.MaxEmployeeCount().get();
    }

    @GetMapping("/account-min")
    @ResponseStatus(HttpStatus.OK)
    public Integer minEmployeeCount() {
        return accountRepository.MinEmployeeCount().get();
    }

    @GetMapping("/account-mean")
    @ResponseStatus(HttpStatus.OK)
    public double meanEmployeeCount() {
        return accountRepository.findMeanEmployeeCount().get();
    }
}
