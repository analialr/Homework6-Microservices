package com.ironhack.leadservice.controller.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.leadservice.models.Lead;
import com.ironhack.leadservice.repository.LeadRepository;
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
class LeadControllerImplTest {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Lead lead1, lead2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        lead1 = new Lead("Mike", "mike@gmail.com", 654789667, "Irontruck", 2L);
        lead2 = new Lead("Fran", "fran@gmail.com", 676549667, "Aqua", 3L);
        leadRepository.saveAll(List.of(lead1, lead2));
    }

    @AfterEach
    void tearDown() {
        leadRepository.deleteAll();
    }

    @Test
    void findAll() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/leads"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Mike"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Fran"));
    }

    @Test
    void findById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/leads/"+lead1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Mike"));
    }

    @Test
    void create() throws Exception {
        Lead lead3 = new Lead("Ruth", "ruth@gmail.com", 478908765, "Apple");
        String body = objectMapper.writeValueAsString(lead3);
        MvcResult mvcResult = mockMvc.perform(
                        post("/leads")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ruth"));
        assertEquals(3, leadRepository.findAll().size());
    }

    @Test
    void delete() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/leads/" + lead1.getId()))
                .andExpect(status().isNoContent())
                .andReturn();
        assertFalse(leadRepository.existsById(lead1.getId()));
    }

    @Test
    void countLeadsBySalesRep() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/leads-by-salesrep/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(lead1.getSalesRep().toString()));
    }
}