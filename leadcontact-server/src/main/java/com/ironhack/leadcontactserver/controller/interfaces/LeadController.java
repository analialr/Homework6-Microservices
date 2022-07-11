package com.ironhack.leadcontactserver.controller.interfaces;

import com.ironhack.leadcontactserver.models.Lead;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;
import java.util.Optional;

public interface LeadController {
    List<Lead> findAll();
    Lead findById(Long id);
    Lead create(Lead lead);
    void delete(Long id);
}
