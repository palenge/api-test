package com.example.restservice.use_cases;

import com.example.restservice.adapters.repositories.LastNameMemoryRepository;
import com.example.restservice.domain.LastName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GetAllLastNames {

    private final LastNameMemoryRepository LastNameMemoryRepository;

    public GetAllLastNames(LastNameMemoryRepository LastNameMemoryRepository) {
        this.LastNameMemoryRepository = LastNameMemoryRepository;
    }

    public CompletableFuture<List<LastName>> execute() {
        return this.LastNameMemoryRepository.findAll();
    }
}
