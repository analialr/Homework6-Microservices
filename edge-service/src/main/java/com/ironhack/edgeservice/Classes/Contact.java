package com.ironhack.edgeservice.Classes;

public class Contact {
    private String name;
    private String email;
    private int phoneNumber;
    private String companyName;
    private Long account;
    private Long salesRep;

    public Contact() {
    }

    public Contact(String name, String email, int phoneNumber, String companyName, Long salesRep) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.salesRep = salesRep;
    }

    public Contact(String name, String email, int phoneNumber, String companyName, Long salesRep, Long account) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.salesRep = salesRep;
        this.account = account;
    }



    public Long getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Long salesRep) {
        this.salesRep = salesRep;
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

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long idAccount) {
        this.account = account;
    }
}
