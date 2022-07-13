package com.ironhack.accountservice.repository;

import com.ironhack.accountservice.enums.Status;
import com.ironhack.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findById(Long id);
    //Report mean number employee count for all Accounts

    @Query("SELECT AVG(employeeCount) FROM Account")
    Optional<Double> findMeanEmployeeCount();

    //Report Maximum  employee count for all Accounts
    @Query("SELECT MAX(employeeCount) FROM Account")
    Optional<Integer> MaxEmployeeCount();

    //Report Minimum  employee count for all Accounts
    @Query("SELECT MIN(employeeCount) FROM Account")
    Optional<Integer> MinEmployeeCount();




    // OPPORTUNITY MEETS ACCOUNT :D

//    //---------------- BY COUNTRY ----------------//
//
//    @Query("SELECT a.country, count(o) FROM Account a JOIN a.opportunityList o GROUP BY a.country")
//    List<Object[]> countOppsByCountry();
//
//    @Query("SELECT a.country, count(o) FROM Account a JOIN a.opportunityList o WHERE o.status ='CLOSED_WON' GROUP BY a.country")
//    List<Object[]> countOppsByClosedWonStatusAndCountry(@Param("status") Status status);
//
//    @Query("SELECT a.country, count(o) FROM Account a JOIN a.opportunityList o WHERE o.status = 'CLOSED_LOST' GROUP BY a.country")
//    List<Object[]> countOppsByClosedLostAndCountry(@Param("status") Status status);
//
//
//    @Query("SELECT  a.country, count(o) FROM Account a JOIN a.opportunityList o WHERE o.status = 'OPEN' GROUP BY a.country")
//    List<Object[]> countOppsByOpenAndCountry(@Param("status") Status status);
//
//
//    //---------------- BY CITY ----------------//
//    @Query("SELECT a.city, count(o) FROM Account a JOIN a.opportunityList o GROUP BY a.city")
//    List<Object[]> countOppsByCity();
//
//    @Query("SELECT a.city, count(o) FROM Account a JOIN a.opportunityList o WHERE o.status = 'CLOSED_WON' GROUP BY a.city")
//    List<Object[]> countOppsByClosedWonAndCity(@Param("status") Status status);
//
//    @Query("SELECT a.city, count(o) FROM Account a JOIN a.opportunityList o WHERE o.status = 'CLOSED_LOST' GROUP BY a.city")
//    List<Object[]> countOppsByClosedLostAndCity(@Param("status") Status status);
//
//    @Query("SELECT count(o) FROM Account a JOIN a.opportunityList o WHERE o.status = 'OPEN' GROUP BY a.city")
//    List<Object[]> countOppsByOpenAndCity(@Param("status") Status status);
//
//
//
//
//    //---------------- BY INDUSTRY ----------------//
//
//    //    A count of all Opportunities by industry can be displayed by typing “Report Opportunity by Industry”
//    @Query("SELECT a.industry, count(o)  FROM Account a JOIN a.opportunityList o GROUP BY a.industry")
//    List<Object[] > countOpportunitiesByIndustry();
//
//    //    A count of all CLOSED_WON Opportunities by industry can be displayed by typing “Report CLOSED-WON by Industry”
//    @Query("SELECT a.industry, count(o)  FROM Account a JOIN a.opportunityList o WHERE o.status= 'CLOSED_WON' GROUP BY a.industry")
//    List<Object[] > countOpportunitiesByIndustryAndStatusCLOSED_WON();
//
//    //    A count of all CLOSED_LOST Opportunities by industry can be displayed by typing “Report CLOSED-LOST by Industry”
//    @Query("SELECT a.industry, count(o)  FROM Account a JOIN a.opportunityList o WHERE o.status= 'CLOSED_LOST' GROUP BY a.industry")
//    List<Object[] > countOpportunitiesByIndustryAndStatusCLOSED_LOST();
//
//    //    A count of all OPEN Opportunities by industry can be displayed by typing “Report OPEN by Industry”
//    @Query("SELECT a.industry, count(o)  FROM Account a JOIN a.opportunityList o WHERE o.status= 'OPEN' GROUP BY a.industry")
//    List<Object[] > countOpportunitiesByIndustryAndStatusOPEN();
//




}
