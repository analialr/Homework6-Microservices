package com.ironhack.edgeservice.Service.Impl;

import com.ironhack.edgeservice.Classes.*;
import com.ironhack.edgeservice.Client.*;
import com.ironhack.edgeservice.Controller.DTO.AccountDTO;
import com.ironhack.edgeservice.Service.Interfaces.EdgeService;
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


    public void convertLead(Long id, Opportunity opportunity) {
        Opportunity opportunity1 = opportunityServiceClient.create(opportunity);
        Lead lead1 = leadServiceClient.findById(id);
        Contact contact1 = new Contact(lead1.getName(), lead1.getEmail(), lead1.getPhoneNumber(), lead1.getCompanyName(), lead1.getSalesRep());
        Contact contact2 = contactServiceClient.create(contact1);
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
