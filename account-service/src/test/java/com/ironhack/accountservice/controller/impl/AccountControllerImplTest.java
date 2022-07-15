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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration(locations={"classpath:WEB-INF/application-context.xml"})
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
        account1 = new Account(30, Industry.MANUFACTURING, "Dolores", "Uruguay");
        account2 = new Account(25, Industry.MEDICAL, "Madrid", "Spain");
        opportunity1 = new Opportunity(Product.BOX, 15, 1L, Status.OPEN, account1, 2L);
        opportunity2 = new Opportunity(Product.FLATBED, 30, 2L, Status.CLOSED_WON, account1, 3L);
        opportunity3 = new Opportunity(Product.FLATBED, 50, 2L, Status.CLOSED_LOST, account2, 3L);
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
    void maxEmployeeCount() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/account-max/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(Optional.of(30), accountRepository.MaxEmployeeCount());

    }

    @Test
    void minEmployeeCount() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/account-min/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(Optional.of(25), accountRepository.MinEmployeeCount());
    }

    @Test
    void meanEmployeeCount() throws Exception  {
        MvcResult mvcResult = mockMvc.perform(get("/account-mean/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(Optional.of(27.5), accountRepository.findMeanEmployeeCount());
    }

    @Test
    void countOppsByCountry() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-country/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getCountry().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account2.getCountry().toString()));
    }

    @Test
    void countOppsByClosedWonStatusAndCountry() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-closewon-country/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account2.getCountry().toString()));
    }

    @Test
    void countOppsByClosedLostAndCountry() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-closelost-country/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account2.getCountry().toString()));
    }

    @Test
    void countOppsByOpenAndCountry() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-open-country/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getCountry().toString()));
    }

    @Test
    void countOppsByCity() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-city/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getCity().toString()));
    }

    @Test
    void countOppsByClosedWonAndCity() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-close-won-city"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account2.getCity().toString()));
    }

    @Test
    void countOppsByClosedLostAndCity() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-close-lost-city"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account2.getCity().toString()));
    }

    @Test
    void countOppsByOpenAndCity() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-open-city"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getCity().toString()));
    }

    @Test
    void countOpportunitiesByIndustry() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-industry"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getIndustry().toString()));
    }

    @Test
    void countOpportunitiesByIndustryAndStatusCLOSED_WON() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-industry-close-won"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account2.getIndustry().toString()));
    }

    @Test
    void countOpportunitiesByIndustryAndStatusCLOSED_LOST() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-industry-close-lost"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account2.getIndustry().toString()));
    }

    @Test
    void countOpportunitiesByIndustryAndStatusOPEN() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opps-by-industry-open"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(account1.getIndustry().toString()));
    }
}