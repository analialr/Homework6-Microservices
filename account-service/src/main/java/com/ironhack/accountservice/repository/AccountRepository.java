package com.ironhack.accountservice.repository;

import com.ironhack.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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





//    // Nuevo query para hacer
//    @Query("SELECT a.id FROM Account a GROUP BY a.country")
//    List<Object[]> findAccountsGroupByCountry();
//
//    @Query("SELECT a.id FROM Account a GROUP BY a.city")
//    List<Object[]> findAccountsGroupByCity();
//
//    @Query("SELECT a.id FROM Account a GROUP BY a.industry")
//    List<Object[]> findAccountsGroupByIndustry();
}
