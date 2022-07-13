package com.ironhack.salesrepservice.repository;

import com.ironhack.salesrepservice.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {
    Optional<SalesRep> findById(Long id);

}
