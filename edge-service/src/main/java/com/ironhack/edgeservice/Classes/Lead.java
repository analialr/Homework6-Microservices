package com.ironhack.edgeservice.Classes;

public class Lead {
    private Long id;
    private String name;
    private String email;
    private int phoneNumber;
    private String companyName;
    private Long salesRep;

    public Lead() {
    }

    public Lead(String name, String email, int phoneNumber, String companyName) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
    }

    public Lead(String name, String email, int phoneNumber, String companyName, Long salesRep) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.salesRep = salesRep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Long salesRep) {
        this.salesRep = salesRep;
    }
}
