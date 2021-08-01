package com.example.restservice.domain.exceptions;

public class IndexNotFoundException extends Exception {
    public IndexNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
