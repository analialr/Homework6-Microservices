package com.ironhack.edgeservice.Controller.Interfaces;

import com.ironhack.edgeservice.Classes.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface EdgeController {

    // SHOW METHODS //

    List<Lead> showLeads();
    List<Contact> showContacts();
    List<Opportunity> showOpportunities();
    List<SalesRep> showSalesReps();
    List<Account> showAccounts();

    // LOOK-UP METHODS //

    Lead lookUpLead(@PathVariable Long id);
    Contact lookUpContact(@PathVariable Long id);
    Opportunity lookUpOpportunity(@PathVariable Long id);
    SalesRep lookUpSalesRep(@PathVariable Long id);
    Account lookUpAccount(@PathVariable Long id);

    // CREATE METHODS //

    Lead newLead(@RequestBody Lead lead);
    SalesRep newSalesRep(@RequestBody SalesRep salesRep);
    Account newAccount(@RequestBody Account account);

    // CONVERT METHODS //

    void convertLead(@PathVariable Long id, @RequestBody Opportunity opportunity);

    // MAX METHODS //
    Integer maxEmployeeCount();

    // MIN METHODS //
    Integer minEmployeeCount();

    // MEAN METHODS //
    double meanEmployeeCount();

    // QUERIES BY PRODUCT //

    List<Object[] >  countOpportunitiesByProduct();
    List<Object[] > countOpportunitiesByProductAndStatusCLOSED_WON();
    List<Object[] > countOpportunitiesByProductAndStatusCLOSED_LOST();
    List<Object[] > countOpportunitiesByProductAndStatusOPEN();

    // QUANTITY STATES QUERIES //
    Double findMeanProductQuantity();
    Integer findMaxProductQuantity();
    Integer findMinProductQuantity();

    //GET LEADS BY SALES REP
    public List<Object[]> countLeadsBySalesRep();
}
