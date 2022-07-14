package com.ironhack.contactservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.contactservice.models.Contact;
import com.ironhack.contactservice.repository.ContactRepository;
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
class ContactControllerImplTest {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Contact contact1, contact2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        contact1 = new Contact("Mike", "mike@gmail.com", 654789667, "Irontruck", 2L);
        contact2 = new Contact("Fran", "fran@gmail.com", 676549667, "Aqua", 3L);
        contactRepository.saveAll(List.of(contact1, contact2));
    }

    @AfterEach
    void tearDown() {
        contactRepository.deleteAll();
    }

    @Test
    void findAll() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/contacts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Mike"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Fran"));
    }

    @Test
    void findById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/contacts/"+contact1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Mike"));
    }

    @Test
    void create() throws Exception {
        Contact contact3 = new Contact("Ruth", "ruth@gmail.com", 478908765, "Apple", 4L);
        String body = objectMapper.writeValueAsString(contact3);
        MvcResult mvcResult = mockMvc.perform(
                        post("/contacts")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ruth"));
        assertEquals(3, contactRepository.findAll().size());
    }

    @Test
    void delete() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/contacts/" + contact1.getId()))
                .andExpect(status().isNoContent())
                .andReturn();
        assertFalse(contactRepository.existsById(contact1.getId()));
    }
}