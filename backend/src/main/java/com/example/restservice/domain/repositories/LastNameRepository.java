package com.example.restservice.domain.repositories;

import com.example.restservice.domain.LastName;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface LastNameRepository {
    CompletableFuture<LastName> getRandom();
    CompletableFuture<LastName> get(long id);
    CompletableFuture<LastName> insert(LastName value);
    CompletableFuture delete(long id);
    CompletableFuture<List<LastName>> findAll();
}
