package com.ironhack.edgeservice.Controller.DTO;

import com.ironhack.edgeservice.Enums.Industry;

import java.util.List;

public class AccountDTO {
    private Long id;
    private int employeeCount;
    private Industry industry;
    private String city;
    private String country;

    private List<Long> contactList;
    private List<Long> opportunityList;


    public AccountDTO() {
    }

    public AccountDTO(int employeeCount, Industry industry, String city, String country) {
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


    public List<Long> getContactList() {
        return this.contactList;
    }

    public void setContactList(List<Long> contactList) {
        this.contactList = contactList;
    }

    public List<Long> getOpportunityList() {
        return this.opportunityList;
    }

    public void setOpportunityList(List<Long> opportunityList) {
        this.opportunityList = opportunityList;
    }


}
