package com.example.restservice.domain.repositories;

import com.example.restservice.domain.FirstName;
import com.example.restservice.domain.FullName;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FullNameRepository {
    CompletableFuture<FullName> getLast();
    CompletableFuture<FullName> insert(FullName value);
}
