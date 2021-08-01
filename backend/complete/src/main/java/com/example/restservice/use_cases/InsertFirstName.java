package com.example.restservice.use_cases;

import com.example.restservice.adapters.repositories.FirstNameMemoryRepository;
import com.example.restservice.domain.FirstName;
import com.example.restservice.domain.repositories.FirstNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class InsertFirstName {

    private final FirstNameRepository firstNameMemoryRepository;

    public InsertFirstName(FirstNameMemoryRepository firstNameMemoryRepository) {
        this.firstNameMemoryRepository = firstNameMemoryRepository;
    }

    public CompletableFuture<FirstName> execute(FirstName value) {
        return this.firstNameMemoryRepository.insert(value);
    }
}
