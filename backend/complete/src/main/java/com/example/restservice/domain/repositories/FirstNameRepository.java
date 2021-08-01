package com.example.restservice.domain.repositories;

import com.example.restservice.domain.FirstName;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FirstNameRepository {
    CompletableFuture<FirstName> get(long id);
    CompletableFuture<FirstName> getRandom();
    CompletableFuture<FirstName> insert(FirstName value);
    CompletableFuture delete(long id);
    CompletableFuture<List<FirstName>> findAll();
}
