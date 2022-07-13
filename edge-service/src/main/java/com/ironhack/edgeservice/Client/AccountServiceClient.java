package com.ironhack.edgeservice.Client;

import com.ironhack.edgeservice.Classes.Account;
import com.ironhack.edgeservice.Enums.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("account-service")
public interface AccountServiceClient {

    @GetMapping("/accounts")
    public List<Account> findAll();

    @GetMapping("/accounts/{id}")
    public Account findById(@PathVariable Long id);

    @PostMapping("/accounts")
    public Account create(@RequestBody Account contact);

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable Long id);

    @GetMapping("/account-max")
    public Integer maxEmployeeCount();

    @GetMapping("/account-min")
    public Integer minEmployeeCount();

    @GetMapping("/account-mean")
    public double meanEmployeeCount();

    @GetMapping("/count-opp-by-product")
    List<Object[] >  countOpportunitiesByProduct();
    @GetMapping("/count-opp-by-product-closed-won")
    List<Object[] > countOpportunitiesByProductAndStatusCLOSED_WON();
    @GetMapping("/count-opp-by-product-closed-lost")
    List<Object[] > countOpportunitiesByProductAndStatusCLOSED_LOST();
    @GetMapping("/count-opp-by-product-open")
    List<Object[] > countOpportunitiesByProductAndStatusOPEN();

    // ACCOUNT MEET OPPORTUNITY :D //

    @GetMapping("/opps-by-country")
    public List<Object[]> countOppsByCountry();

    @GetMapping("/opps-by-closewon-country")
    public List<Object[]> countOppsByClosedWonStatusAndCountry(Status status);

    @GetMapping("/opps-by-losewon-country")
    public List<Object[]> countOppsByClosedLostAndCountry(Status status);

    @GetMapping("/opps-by-open-country")
    public List<Object[]> countOppsByOpenAndCountry(Status status);

    @GetMapping("/opps-by-city")
    public List<Object[]> countOppsByCity();

    @GetMapping("/opps-by-close-won-city")
    public List<Object[]> countOppsByClosedWonAndCity(Status status);

    @GetMapping("/opps-by-close-lost-city")
    public List<Object[]> countOppsByClosedLostAndCity(Status status);

    @GetMapping("/opps-open-by-city")
    public List<Object[]> countOppsByOpenAndCity(Status status);

    @GetMapping("/opps-by-industry")
    public List<Object[]> countOpportunitiesByIndustry();

    @GetMapping("/opps-by-industry-close-won")
    public List<Object[]> countOpportunitiesByIndustryAndStatusCLOSED_WON();

    @GetMapping("/opps-by-industry-close-lost")
    public List<Object[]> countOpportunitiesByIndustryAndStatusCLOSED_LOST();

    @GetMapping("/opps-by-industry-open")
    public List<Object[]> countOpportunitiesByIndustryAndStatusOPEN();
}
