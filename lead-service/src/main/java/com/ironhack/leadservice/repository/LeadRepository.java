package com.ironhack.leadservice.repository;

import com.ironhack.leadservice.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    Optional<Lead> findById(Long id);

    //---------------- BY SALESREP ----------------//

    // A count of Leads by SalesRep can be displayed by typing “Report Lead by SalesRep”
    @Query(value = "SELECT l.salesRep, count(l) FROM Lead l GROUP BY l.salesRep")
    List<Object[] > countLeadsBySalesRep();

}
