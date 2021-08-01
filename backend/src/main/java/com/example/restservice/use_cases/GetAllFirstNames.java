package com.example.restservice.use_cases;

import com.example.restservice.adapters.repositories.FirstNameMemoryRepository;
import com.example.restservice.domain.FirstName;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GetAllFirstNames {

    private final FirstNameMemoryRepository firstNameMemoryRepository;

    public GetAllFirstNames(FirstNameMemoryRepository firstNameMemoryRepository) {
        this.firstNameMemoryRepository = firstNameMemoryRepository;
    }

    public CompletableFuture<List<FirstName>> execute() {
        return this.firstNameMemoryRepository.findAll();
    }
}
