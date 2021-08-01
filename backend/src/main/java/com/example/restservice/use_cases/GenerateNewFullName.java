package com.example.restservice.use_cases;

import com.example.restservice.domain.FirstName;
import com.example.restservice.domain.FullName;
import com.example.restservice.domain.LastName;
import com.example.restservice.domain.repositories.FirstNameRepository;
import com.example.restservice.domain.repositories.FullNameRepository;
import com.example.restservice.domain.repositories.LastNameRepository;
import com.example.restservice.use_cases.exceptions.NameGenerationException;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class GenerateNewFullName {

    private final FullNameRepository fullNameRepository;
    private final FirstNameRepository firstNameRepository;
    private final LastNameRepository lastNameRepository;

    public GenerateNewFullName(FullNameRepository fullNameRepository, FirstNameRepository firstNameRepository, LastNameRepository lastNameRepository) {
        this.fullNameRepository = fullNameRepository;
        this.firstNameRepository = firstNameRepository;
        this.lastNameRepository = lastNameRepository;
    }

    public CompletableFuture<FullName> execute() throws ExecutionException, InterruptedException, NameGenerationException {
        FirstName randomFirstName = this.firstNameRepository.getRandom().get();
        LastName randomLastName = this.lastNameRepository.getRandom().get();

        if(randomFirstName == null || randomLastName == null) {
            throw new NameGenerationException();
        }

        FullName newFullName = new FullName();
        newFullName.setLastName(randomLastName.getLastName());
        newFullName.setFirstName(randomFirstName.getFirstName());

        return this.fullNameRepository.insert(newFullName);
    }
}
