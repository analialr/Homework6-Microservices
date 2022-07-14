package com.ironhack.edgeservice.Service.Impl;

import com.ironhack.edgeservice.Classes.*;
import com.ironhack.edgeservice.Client.*;
import com.ironhack.edgeservice.Controller.DTO.AccountDTO;
import com.ironhack.edgeservice.Enums.Product;
import com.ironhack.edgeservice.Enums.Status;
import com.ironhack.edgeservice.Service.Interfaces.EdgeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeServiceImpl implements EdgeService {

    @Autowired
    private LeadServiceClient leadServiceClient;
    @Autowired
    private SalesRepServiceClient salesRepServiceClient;
    @Autowired
    private AccountServiceClient accountServiceClient;
    @Autowired
    private OpportunityServiceClient opportunityServiceClient;
    @Autowired
    private ContactServiceClient contactServiceClient;


    @CircuitBreaker(name = "convertLead", fallbackMethod = "convertLeadFallBack")
    public void convertLead(Long id, Opportunity opportunity) {
        Opportunity opportunity1 = opportunityServiceClient.create(opportunity);
        Lead lead1 = leadServiceClient.findById(id);
        Contact contact1 = new Contact(lead1.getName(), lead1.getEmail(), lead1.getPhoneNumber(), lead1.getCompanyName(), lead1.getSalesRep());
        Contact contact2 = contactServiceClient.create(contact1);
        leadServiceClient.delete(id);
    }

    public String convertLeadFallBack(Long id, Opportunity opportunity, Exception e) {
        Opportunity opportunity1 = new Opportunity(Product.BOX, 30, 123456L, Status.OPEN, 1L, 2L);
        Contact contact1 = new Contact("Mike", "mike@gmail.com", 634477559, "Irontruck", 1L);
        String response = "A default contact and opportunity has been created.";

        return response;
    }

    /*
    @Override
    public List<AccountDTO> showAccountsDTO(List<Account> accountList) {
        for(Account account: accountList) {
            AccountDTO accountDTO = new AccountDTO();
        }
        return null;
    }
     */


}
