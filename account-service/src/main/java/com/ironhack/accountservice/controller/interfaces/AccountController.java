package com.ironhack.accountservice.controller.interfaces;

import com.ironhack.accountservice.model.Account;

import java.util.List;

public interface AccountController {
    List<Account> findAll();
    Account findById(Long id);
    Account create(Account account);
    void delete(Long id);
    Integer maxEmployeeCount();
    Integer minEmployeeCount();
    double meanEmployeeCount();
}
