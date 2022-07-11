package com.ironhack.leadcontactserver.repository;

import com.ironhack.leadcontactserver.models.Contact;
import com.ironhack.leadcontactserver.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findById(Long id);

}
