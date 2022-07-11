package com.ironhack.accountserver.repository;

import com.ironhack.accountserver.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findById(Long id);
    //Report mean number employee count for all Accounts
    @Query("SELECT AVG(employeeCount) FROM Account")
    Optional<Double> findMeanEmployeeCount();

    /*
    //Show accounts
    @Query("SELECT ac.id, c.companyName FROM Contact c JOIN c.account ac")
    List<Object[]> AllAccounts();
     */

    //Median Report
    @Query("SELECT employeeCount FROM Account order by employeeCount")
    int[]MedianEmployeeCountStep1();

    //Report Maximum  employee count for all Accounts
    @Query("SELECT MAX(employeeCount) FROM Account")
    Optional<Integer> MaxEmployeeCount();

    //Report Minimum  employee count for all Accounts
    @Query("SELECT MIN(employeeCount) FROM Account")
    Optional<Integer> MinEmployeeCount();
}
