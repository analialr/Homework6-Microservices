package com.ironhack.leadcontactserver.repository;

import com.ironhack.leadcontactserver.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    Optional<Lead> findById(Long id);

}
