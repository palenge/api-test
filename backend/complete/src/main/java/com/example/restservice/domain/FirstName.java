package com.example.restservice.domain;

public class FirstName {
    private long id;
    private String FirstName;

    public FirstName() {
    }

    public FirstName(String firstName) {
        FirstName = firstName;
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

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
}
