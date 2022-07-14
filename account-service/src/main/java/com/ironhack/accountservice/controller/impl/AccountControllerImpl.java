package com.ironhack.accountservice.controller.impl;

import com.ironhack.accountservice.controller.interfaces.AccountController;
import com.ironhack.accountservice.enums.Status;
import com.ironhack.accountservice.model.Account;
import com.ironhack.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountControllerImpl implements AccountController {

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



//    // ACCOUNT MEET OPPORTUNITY :D ///
//
//    @GetMapping("/opps-by-country")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOppsByCountry() {
//        return accountRepository.countOppsByCountry();
//    }
//
//    @GetMapping("/opps-by-closewon-country")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOppsByClosedWonStatusAndCountry(Status status) {
//        return accountRepository.countOppsByClosedWonStatusAndCountry(Status.CLOSED_WON);
//    }
//
//    @GetMapping("/opps-by-losewon-country")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOppsByClosedLostAndCountry(Status status) {
//        return accountRepository.countOppsByClosedLostAndCountry(Status.CLOSED_LOST);
//    }
//
//    @GetMapping("/opps-by-open-country")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOppsByOpenAndCountry(Status status) {
//        return accountRepository.countOppsByOpenAndCountry(Status.OPEN);
//    }
//
//    @GetMapping("/opps-by-city")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOppsByCity() {
//        return accountRepository.countOppsByCity();
//    }
//
//    @GetMapping("/opps-by-close-won-city")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOppsByClosedWonAndCity(Status status) {
//        return accountRepository.countOppsByClosedWonAndCity(Status.CLOSED_WON) ;
//    }
//
//    @GetMapping("/opps-by-close-lost-city")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOppsByClosedLostAndCity(Status status) {
//        return accountRepository.countOppsByClosedLostAndCity(Status.CLOSED_LOST);
//    }
//
//    @GetMapping("/opps-open-by-city")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOppsByOpenAndCity(Status status) {
//        return accountRepository.countOppsByOpenAndCity(Status.OPEN);
//    }
//
//    @GetMapping("/opps-by-industry")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOpportunitiesByIndustry() {
//        return accountRepository.countOpportunitiesByIndustry();
//    }
//
//    @GetMapping("/opps-by-industry-close-won")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOpportunitiesByIndustryAndStatusCLOSED_WON() {
//        return accountRepository.countOpportunitiesByIndustryAndStatusCLOSED_WON();
//    }
//
//    @GetMapping("/opps-by-industry-close-lost")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOpportunitiesByIndustryAndStatusCLOSED_LOST() {
//        return accountRepository.countOpportunitiesByIndustryAndStatusCLOSED_LOST();
//    }
//
//    @GetMapping("/opps-by-industry-open")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Object[]> countOpportunitiesByIndustryAndStatusOPEN() {
//        return accountRepository.countOpportunitiesByIndustryAndStatusOPEN();
//    }


}
