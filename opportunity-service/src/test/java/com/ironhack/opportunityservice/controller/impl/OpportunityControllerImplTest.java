package com.ironhack.opportunityservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.opportunityservice.enums.Product;
import com.ironhack.opportunityservice.enums.Status;
import com.ironhack.opportunityservice.models.Opportunity;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class OpportunityControllerImplTest {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Opportunity opportunity1, opportunity2, opportunity3;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        opportunity1 = new Opportunity(Product.BOX, 15, 1L, Status.OPEN, 2L);
        opportunity2 = new Opportunity(Product.FLATBED, 30, 2L, Status.CLOSED_WON, 3L);
        opportunity3 = new Opportunity(Product.FLATBED, 50, 2L, Status.CLOSED_LOST, 3L);
        opportunityRepository.saveAll(List.of(opportunity1, opportunity2, opportunity3));
    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
    }

    @Test
    void findAll() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opportunities"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("BOX"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("FLATBED"));
    }

    @Test
    void findById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opportunities/"+opportunity1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("BOX"));
    }

    @Test
    void create() throws Exception {
        Opportunity opportunity3 = new Opportunity(Product.HYBRID, 40, 3L, Status.CLOSED_LOST, 4L);
        String body = objectMapper.writeValueAsString(opportunity3);
        MvcResult mvcResult = mockMvc.perform(
                        post("/opportunities")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("HYBRID"));
        assertEquals(4, opportunityRepository.findAll().size());
    }

    @Test
    void delete() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/opportunities/" + opportunity1.getId()))
                .andExpect(status().isNoContent())
                .andReturn();
        assertFalse(opportunityRepository.existsById(opportunity1.getId()));
    }

    @Test
    void countOpportunitiesByProduct() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/count-opp-by-product/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity1.getProduct().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity2.getProduct().toString()));
    }

    @Test
    void countOpportunitiesByProductAndStatusCLOSED_WON() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/count-opp-by-product-closed-won/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity2.getProduct().toString()));
    }

    @Test
    void countOpportunitiesByProductAndStatusCLOSED_LOST() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/count-opp-by-product-closed-lost/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity3.getProduct().toString()));
    }

    @Test
    void countOpportunitiesByProductAndStatusOPEN() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/count-opp-by-product-open/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity1.getProduct().toString()));
    }

    @Test
    void findMeanProductQuantity() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/mean-product-quantity/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(Optional.of(31.6667), opportunityRepository.findMeanProductQuantity());
    }

    @Test
    void findMaxProductQuantity() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/max-product-quantity/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(Optional.of(50), opportunityRepository.findMaxProductQuantity());
    }

    @Test
    void findMinProductQuantity() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/min-product-quantity/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(Optional.of(15), opportunityRepository.findMinProductQuantity());
    }

    @Test
    void countOpportunitiesByProductAndSalesRepCLOSED_WON() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/count-opp-by-prod-n-rep-closed-won/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity2.getId().toString()));
    }

    @Test
    void countOpportunitiesByProductAndSalesRepCLOSED_LOST() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/count-opp-by-prod-n-rep-closed-lost/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity3.getId().toString()));
    }

    @Test
    void countOpportunitiesByProductAndSalesRepOPEN() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/count-opp-by-prod-n-rep-open/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity1.getId().toString()));
    }

    @Test
    void countOpportunityBySalesRep() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/count-opp-by-salesrep/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity1.getSalesRep().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity2.getSalesRep().toString()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(opportunity3.getSalesRep().toString()));
    }
}