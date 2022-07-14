package com.ironhack.contactservice.repository;

import com.ironhack.contactservice.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findById(Long id);
    List<Contact> findByAccount(Long id);

}
