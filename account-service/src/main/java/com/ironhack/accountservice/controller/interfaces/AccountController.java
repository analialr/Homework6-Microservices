package com.ironhack.accountservice.controller.interfaces;

import com.ironhack.accountservice.enums.Status;
import com.ironhack.accountservice.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountController {
    List<Account> findAll();
    Account findById(Long id);
    Account create(Account account);
    void delete(Long id);
    Integer maxEmployeeCount();
    Integer minEmployeeCount();
    double meanEmployeeCount();

//    // ACCOUNT MEET OPPORTUNITY :D
//    //---------------- BY COUNTRY ----------------//
//
//    List<Object[]> countOppsByCountry();
//    List<Object[]> countOppsByClosedWonStatusAndCountry(Status status);
//    List<Object[]> countOppsByClosedLostAndCountry(Status status);
//    List<Object[]> countOppsByOpenAndCountry(Status status);
//
//
//    //---------------- BY CITY ----------------//
//    List<Object[]> countOppsByCity();
//    List<Object[]> countOppsByClosedWonAndCity(Status status);
//    List<Object[]> countOppsByClosedLostAndCity(Status status);
//    List<Object[]> countOppsByOpenAndCity(Status status);
//
//
//    //---------------- BY INDUSTRY ----------------//
//
//    List<Object[] > countOpportunitiesByIndustry();
//    List<Object[] > countOpportunitiesByIndustryAndStatusCLOSED_WON();
//    List<Object[] > countOpportunitiesByIndustryAndStatusCLOSED_LOST();
//    List<Object[] > countOpportunitiesByIndustryAndStatusOPEN();


}
