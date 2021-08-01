package com.example.restservice.domain;

public class FullName {
    private long id;
    private String FirstName;
    private String LastName;

    public FullName() {
    }

    public FullName(String name, String lastName) {
        FirstName = name;
        LastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String name) {
        FirstName = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
