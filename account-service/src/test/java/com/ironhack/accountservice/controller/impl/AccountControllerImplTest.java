package com.ironhack.accountservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.accountservice.enums.Industry;
import com.ironhack.accountservice.enums.Product;
import com.ironhack.accountservice.enums.Status;
import com.ironhack.accountservice.model.Account;
import com.ironhack.accountservice.model.Opportunity;
import com.ironhack.accountservice.repository.AccountRepository;
import com.ironhack.accountservice.repository.OpportunityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AccountControllerImplTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Opportunity opportunity1, opportunity2, opportunity3;
    private Account account1, account2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        opportunity1 = new Opportunity(Product.BOX, 15, 1L, Status.OPEN, 2L);
        opportunity2 = new Opportunity(Product.FLATBED, 30, 2L, Status.CLOSED_WON, 3L);
        opportunity3 = new Opportunity(Product.FLATBED, 50, 2L, Status.CLOSED_LOST, 3L);
        account1 = new Account(30, Industry.MANUFACTURING, "Dolores", "Uruguay");
        account2 = new Account(25, Industry.MEDICAL, "Madrid", "Spain");
        opportunityRepository.saveAll(List.of(opportunity1, opportunity2, opportunity3));
        accountRepository.saveAll(List.of(account1, account2));

    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
        opportunityRepository.deleteAll();
    }

    @Test
    void findAll() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("MANUFACTURING"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("MEDICAL"));
    }

    @Test
    void findById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/accounts/"+account1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("MANUFACTURING"));
    }

    @Test
    void create() throws Exception {
        Account account3 = new Account(17, Industry.ECOMMERCE, "Sevilla", "Spain");
        String body = objectMapper.writeValueAsString(account3);
        MvcResult mvcResult = mockMvc.perform(
                        post("/accounts")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("ECOMMERCE"));
        assertEquals(3, accountRepository.findAll().size());
    }

    @Test
    void delete() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/accounts/" + account1.getId()))
                .andExpect(status().isNoContent())
                .andReturn();
        assertFalse(accountRepository.existsById(account1.getId()));
    }

    @Test
    void maxEmployeeCount() {
    }

    @Test
    void minEmployeeCount() {
    }

    @Test
    void meanEmployeeCount() {
    }

    @Test
    void countOppsByCountry() {
    }

    @Test
    void countOppsByClosedWonStatusAndCountry() {
    }

    @Test
    void countOppsByClosedLostAndCountry() {
    }

    @Test
    void countOppsByOpenAndCountry() {
    }

    @Test
    void countOppsByCity() {
    }

    @Test
    void countOppsByClosedWonAndCity() {
    }

    @Test
    void countOppsByClosedLostAndCity() {
    }

    @Test
    void countOppsByOpenAndCity() {
    }

    @Test
    void countOpportunitiesByIndustry() {
    }

    @Test
    void countOpportunitiesByIndustryAndStatusCLOSED_WON() {
    }

    @Test
    void countOpportunitiesByIndustryAndStatusCLOSED_LOST() {
    }

    @Test
    void countOpportunitiesByIndustryAndStatusOPEN() {
    }
}