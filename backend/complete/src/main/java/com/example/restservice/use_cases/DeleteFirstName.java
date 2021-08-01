package com.example.restservice.use_cases;

import com.example.restservice.adapters.repositories.FirstNameMemoryRepository;
import com.example.restservice.domain.FirstName;
import com.example.restservice.domain.repositories.FirstNameRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DeleteFirstName {

    private final FirstNameRepository firstNameMemoryRepository;

    public DeleteFirstName(FirstNameMemoryRepository firstNameMemoryRepository) {
        this.firstNameMemoryRepository = firstNameMemoryRepository;
    }

    public CompletableFuture<FirstName> execute(long id) {
        return this.firstNameMemoryRepository.delete(id);
    }
}
