package com.ironhack.salesrepservice.controller.interfaces;

import com.ironhack.salesrepservice.model.SalesRep;

import java.util.List;
import java.util.Optional;

public interface SalesRepController {
    SalesRep findById(Long id);
    List<SalesRep> findAll();
    SalesRep create(SalesRep salesRep);
    void delete(Long id);
}
