package com.ironhack.accountserver.controller.interfaces;

import com.ironhack.accountserver.model.Account;

import java.util.List;

public interface AccountController {
    List<Account> findAll();
    Account findById(Long id);
    Account create(Account account);
    void delete(Long id);
}
