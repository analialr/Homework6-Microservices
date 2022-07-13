package com.ironhack.edgeservice.Controller.Impl;

import com.ironhack.edgeservice.Classes.*;
import com.ironhack.edgeservice.Client.*;
import com.ironhack.edgeservice.Controller.Interfaces.EdgeController;
import com.ironhack.edgeservice.Service.Interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EdgeControllerImpl implements EdgeController {

    @Autowired
    private LeadServiceClient leadServiceClient;
    @Autowired
    private ContactServiceClient contactServiceClient;
    @Autowired
    private OpportunityServiceClient opportunityServiceClient;
    @Autowired
    private SalesRepServiceClient salesRepServiceClient;
    @Autowired
    private AccountServiceClient accountServiceClient;

    @Autowired
    private EdgeService edgeService;

    // SHOW METHODS //

    @GetMapping("/show-leads")
    @ResponseStatus(HttpStatus.OK)
    public List<Lead> showLeads() {
        return leadServiceClient.findAll();
    }

    @GetMapping("/show-contacts")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> showContacts() {
        return contactServiceClient.findAll();
    }

    @GetMapping("/show-opportunities")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> showOpportunities() {
        return opportunityServiceClient.findAll();
    }

    @GetMapping("/show-salesreps")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesRep> showSalesReps() {
        return salesRepServiceClient.findAll();
    }

    @GetMapping("/show-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> showAccounts() {
        return accountServiceClient.findAll();
    }

    // LOOK-UP METHODS //

    @GetMapping("/lookup-lead/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lead lookUpLead(@PathVariable Long id) {
        return leadServiceClient.findById(id);
    }

    @GetMapping("/lookup-contact/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact lookUpContact(@PathVariable Long id) {
        return contactServiceClient.findById(id);
    }

    @GetMapping("/lookup-opportunity/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Opportunity lookUpOpportunity(@PathVariable Long id) {
        return opportunityServiceClient.findById(id);
    }

    @GetMapping("/lookup-salesrep/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalesRep lookUpSalesRep(@PathVariable Long id) {
        return salesRepServiceClient.findById(id);
    }

    @GetMapping("/lookup-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account lookUpAccount(@PathVariable Long id) {
        return accountServiceClient.findById(id);
    }

    // CREATE METHODS //

    @PostMapping("/new-lead")
    @ResponseStatus(HttpStatus.CREATED)
    public Lead newLead(@RequestBody Lead lead) {
        return leadServiceClient.create(lead);
    }

    @PostMapping("/new-salesrep")
    @ResponseStatus(HttpStatus.CREATED)
    public SalesRep newSalesRep(@RequestBody SalesRep salesRep) {
        return salesRepServiceClient.create(salesRep);
    }

    @PostMapping("/new-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account newAccount(@RequestBody Account account) {
        return accountServiceClient.create(account);
    }

    // CONVERT METHOD //

    @PostMapping("/convert-leads")
    @ResponseStatus(HttpStatus.CREATED)
    public void convertLead(@PathVariable Long id, @RequestBody Opportunity opportunity) {
        edgeService.convertLead(id, opportunity);
    }

    // MAX QUERIES //
    @GetMapping("/max-employee-count")
    @ResponseStatus(HttpStatus.OK)
    public Integer maxEmployeeCount() {
        return accountServiceClient.maxEmployeeCount();
    }

    // MIN QUERIES //
    @GetMapping("/min-employee-count")
    @ResponseStatus(HttpStatus.OK)
    public Integer minEmployeeCount() {
        return accountServiceClient.minEmployeeCount();
    }

    // MEAN QUERIES //
    @GetMapping("/mean-employee-count")
    @ResponseStatus(HttpStatus.OK)
    public double meanEmployeeCount() {
        return accountServiceClient.meanEmployeeCount();
    }

    // QUERIES OPP BY PRODUCT //
    @GetMapping("/count-opp-by-product")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> countOpportunitiesByProduct() {
        return accountServiceClient.countOpportunitiesByProduct();
    }
    @GetMapping("/count-opp-by-product-closed-won")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> countOpportunitiesByProductAndStatusCLOSED_WON() {
        return accountServiceClient.countOpportunitiesByProductAndStatusCLOSED_WON();
    }
    @GetMapping("/count-opp-by-product-closed-lost")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> countOpportunitiesByProductAndStatusCLOSED_LOST() {
        return accountServiceClient.countOpportunitiesByProductAndStatusCLOSED_LOST();
    }
    @GetMapping("/count-opp-by-product-open")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> countOpportunitiesByProductAndStatusOPEN() {
        return accountServiceClient.countOpportunitiesByProductAndStatusOPEN();
    }

    // QUANTITY STATES QUERIES //
    @GetMapping("/mean-product-quantity")
    @ResponseStatus(HttpStatus.OK)
    public Double findMeanProductQuantity() {
        return opportunityServiceClient.findMeanProductQuantity();
    }
    @GetMapping("/max-product-quantity")
    @ResponseStatus(HttpStatus.OK)
    public Integer findMaxProductQuantity() {
        return opportunityServiceClient.findMaxProductQuantity();
    }
    @GetMapping("/min-product-quantity")
    @ResponseStatus(HttpStatus.OK)
    public Integer findMinProductQuantity() {
        return opportunityServiceClient.findMinProductQuantity();
    }


    // COUNT LEAD BY REP SALES
    @GetMapping("/leads-by-salesrep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> countLeadsBySalesRep() { return leadServiceClient.countLeadsBySalesRep();}
}
