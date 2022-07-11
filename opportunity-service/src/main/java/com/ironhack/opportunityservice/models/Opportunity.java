package com.ironhack.opportunityservice.models;

import com.ironhack.opportunityservice.enums.Product;
import com.ironhack.opportunityservice.enums.Status;

import javax.persistence.*;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Product product;
    private int quantity;

    @JoinColumn(name = "decision_maker")
    private Long decisionMaker;
    @Enumerated(EnumType.STRING)
    private Status status;

    @JoinColumn(name = "account_id")
    private Long account;

    @JoinColumn(name = "sales_rep_id")
    private Long salesRep;

    public Opportunity() {
    }

    public Opportunity(Product product, int quantity, Long decisionMaker, Status status, Long salesRep) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRep = salesRep;
    }
    public Opportunity(Product product, int quantity, Long decisionMaker, Status status,
                       Long account, Long salesRep) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.account = account;
        this.salesRep = salesRep;
    }



    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Long decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Long getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Long salesRep) {
        this.salesRep = salesRep;
    }
}
