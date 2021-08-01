package com.example.restservice.use_cases;

import com.example.restservice.adapters.repositories.LastNameMemoryRepository;
import com.example.restservice.domain.LastName;
import com.example.restservice.domain.repositories.LastNameRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class InsertLastName {

    private final LastNameRepository LastNameMemoryRepository;

    public InsertLastName(LastNameMemoryRepository LastNameMemoryRepository) {
        this.LastNameMemoryRepository = LastNameMemoryRepository;
    }

    public CompletableFuture<LastName> execute(LastName value) {
        return this.LastNameMemoryRepository.insert(value);
    }
}
