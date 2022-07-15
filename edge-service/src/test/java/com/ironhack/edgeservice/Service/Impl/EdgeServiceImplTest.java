package com.ironhack.edgeservice.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.edgeservice.Classes.Contact;
import com.ironhack.edgeservice.Classes.Lead;
import com.ironhack.edgeservice.Classes.Opportunity;
import com.ironhack.edgeservice.Client.ContactServiceClient;
import com.ironhack.edgeservice.Client.LeadServiceClient;
import com.ironhack.edgeservice.Client.OpportunityServiceClient;
import com.ironhack.edgeservice.Enums.Product;
import com.ironhack.edgeservice.Enums.Status;
import com.ironhack.edgeservice.Service.Interfaces.EdgeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EdgeServiceImplTest {

    @Autowired
    private EdgeService edgeService;

    @MockBean
    private OpportunityServiceClient opportunityServiceClient;

    @MockBean
    private ContactServiceClient contactServiceClient;

    @MockBean
    private LeadServiceClient leadServiceClient;

    private Opportunity opportunity;
    private Contact contact;
    private Lead lead;

    @BeforeEach
    void setUp() {
        opportunity = new Opportunity(Product.BOX, 15, 1L, Status.OPEN, 2L);
        contact = new Contact("Mike", "mike@gmail.com", 654789667, "Irontruck", 2L);
        lead = new Lead("Mike", "mike@gmail.com", 654789667, "Irontruck", 2L);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void convertLead() {
        Opportunity opportunity1 = new Opportunity(Product.BOX, 15, 1L, Status.OPEN, 2L);
        opportunity1.setId(1L);
        Mockito.when(opportunityServiceClient.create(opportunity))
                .thenReturn(opportunity1);
        Contact contact1 =  new Contact("Mike", "mike@gmail.com", 654789667, "Irontruck", 2L);
        Mockito.when(contactServiceClient.create(contact)).thenReturn(contact1);
        Lead lead1 = new Lead("Mike", "mike@gmail.com", 654789667, "Irontruck", 2L);
        lead1.setId(1L);
        Mockito.when(leadServiceClient.create(lead)).thenReturn(lead1);

        edgeService.convertLead(1L, opportunity);


    }
}