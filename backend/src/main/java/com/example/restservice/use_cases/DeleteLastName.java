package com.example.restservice.use_cases;

import com.example.restservice.adapters.repositories.LastNameMemoryRepository;
import com.example.restservice.domain.LastName;
import com.example.restservice.domain.repositories.LastNameRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DeleteLastName {

    private final LastNameRepository LastNameMemoryRepository;

    public DeleteLastName(LastNameMemoryRepository LastNameMemoryRepository) {
        this.LastNameMemoryRepository = LastNameMemoryRepository;
    }

    public CompletableFuture<LastName> execute(long id) {
        return this.LastNameMemoryRepository.delete(id);
    }
}
