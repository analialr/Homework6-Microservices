package com.ironhack.salesrepservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.salesrepservice.model.SalesRep;
import com.ironhack.salesrepservice.repository.SalesRepRepository;
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
class SalesRepControllerImplTest {

    @Autowired
    private SalesRepRepository salesRepRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private SalesRep salesRep1, salesRep2;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        salesRep1 = new SalesRep("Mike");
        salesRep2 = new SalesRep("Fran");
        salesRepRepository.saveAll(List.of(salesRep1, salesRep2));
    }

    @AfterEach
    void tearDown() {
        salesRepRepository.deleteAll();
    }

    @Test
    void findAll() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/salesreps"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Mike"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Fran"));
    }

    @Test
    void findById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/salesreps/"+salesRep1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Mike"));
    }

    @Test
    void create() throws Exception {
        SalesRep salesRep3 = new SalesRep("Ruth");
        String body = objectMapper.writeValueAsString(salesRep3);
        MvcResult mvcResult = mockMvc.perform(
                        post("/salesreps")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ruth"));
        assertEquals(3, salesRepRepository.findAll().size());
    }

    @Test
    void delete() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/salesreps/" + salesRep1.getId()))
                .andExpect(status().isNoContent())
                .andReturn();
        assertFalse(salesRepRepository.existsById(salesRep1.getId()));
    }
}