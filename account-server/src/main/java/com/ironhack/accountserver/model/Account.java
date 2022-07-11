package com.ironhack.accountserver.model;


import com.ironhack.accountserver.enums.Industry;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account_table")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    private int employeeCount;
    @Enumerated(EnumType.STRING)
    private Industry industry;
    private String city;
    private String country;
    private List<Long> contacList;

    private List<Long> opportunityList;

    public Account() {
    }

    public Account(int employeeCount, Industry industry, String city, String country) {
        this.employeeCount = employeeCount;
        this.industry = industry;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return this.id;
    }

    public int getEmployeeCount() {
        return this.employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Industry getIndustry() {
        return this.industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Long> getContacList() {
        return this.contacList;
    }

    public void setContacList(List<Long> contacList) {
        this.contacList = contacList;
    }

    public List<Long> getOpportunityList() {
        return this.opportunityList;
    }

    public void setOpportunityList(List<Long> opportunityList) {
        this.opportunityList = opportunityList;
    }
}
