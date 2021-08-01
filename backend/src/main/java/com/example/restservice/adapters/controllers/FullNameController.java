package com.example.restservice.adapters.controllers;

import com.example.restservice.domain.FullName;
import com.example.restservice.use_cases.GenerateNewFullName;
import com.example.restservice.use_cases.GetFullName;
import com.example.restservice.use_cases.exceptions.NameGenerationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*")
@RestController
public class FullNameController {

    private final String PREFIX = "/full_name";
    private final GetFullName getFullName;
    private final GenerateNewFullName generateNewFullName;

    public FullNameController(GetFullName getFullName, GenerateNewFullName generateNewFullName) {
        this.getFullName = getFullName;
        this.generateNewFullName = generateNewFullName;
    }

    @GetMapping(PREFIX)
	public CompletableFuture<FullName> get(@RequestParam(required = false) Boolean generate) throws ExecutionException, InterruptedException, NameGenerationException {
        if(generate != null) {
            return generateNewFullName.execute();
        }
        else {
            return this.getFullName.execute();
        }
	}
}
