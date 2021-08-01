package com.example.restservice.adapters.repositories;

import com.example.restservice.domain.FullName;
import com.example.restservice.domain.repositories.FullNameRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public class FullNameMemoryRepository implements FullNameRepository {

    private FullName lastUsed;

    public FullNameMemoryRepository() {
        lastUsed = new FullName();
    }

    @Override
    public CompletableFuture<FullName> getLast() {
        return CompletableFuture.supplyAsync(() -> this.lastUsed);
    }

    @Override
    public CompletableFuture<FullName> insert(FullName value) {
        return CompletableFuture.supplyAsync(() -> {
            this.lastUsed = value;
            return this.lastUsed;
        });
    }
}
