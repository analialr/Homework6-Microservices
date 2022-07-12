package com.ironhack.leadservice.controller.interfaces;

import com.ironhack.leadservice.models.Lead;

import java.util.List;

public interface LeadController {
    List<Lead> findAll();
    Lead findById(Long id);
    Lead create(Lead lead);
    void delete(Long id);
}
