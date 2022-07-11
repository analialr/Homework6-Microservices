package com.ironhack.accountserver.controller.impl;

import com.ironhack.accountserver.model.Account;
import com.ironhack.accountserver.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class AccountControllerImpl {
    @Autowired
    public AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }


    public Account findById(@PathVariable Long id) {
        Optional<Account> optionalContact= accountRepository.findById(id);
        return  optionalContact.get();
    }


    public Account create(@RequestBody Account contact) {
        return accountRepository.save(contact);
    }


    public void delete(Long id) {
        accountRepository.delete(accountRepository.findById(id).get());
    }
}
