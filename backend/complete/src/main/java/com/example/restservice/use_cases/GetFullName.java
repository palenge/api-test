package com.example.restservice.use_cases;

import com.example.restservice.domain.FullName;
import com.example.restservice.domain.repositories.FullNameRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class GetFullName {

    private final FullNameRepository fullNameRepository;

    public GetFullName(FullNameRepository fullNameRepository) {
        this.fullNameRepository = fullNameRepository;
    }

    public CompletableFuture<FullName> execute() {
        return this.fullNameRepository.getLast();
    }
}
