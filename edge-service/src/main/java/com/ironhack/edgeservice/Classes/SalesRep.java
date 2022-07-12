package com.ironhack.edgeservice.Classes;

public class SalesRep {
    private Long id;
    private String name;

    public SalesRep() {
    }

    public SalesRep(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
