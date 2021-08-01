package com.example.restservice.adapters.controllers;

import com.example.restservice.domain.FirstName;
import com.example.restservice.use_cases.DeleteFirstName;
import com.example.restservice.use_cases.GetAllFirstNames;
import com.example.restservice.use_cases.InsertFirstName;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@CrossOrigin(origins = "*")
@RestController
public class FirstNameController {

    private final String PREFIX = "/first_name";
    private final GetAllFirstNames getAllFirstNames;
    private final InsertFirstName insertFirstName;
    private final DeleteFirstName deleteFirstName;

    public FirstNameController(GetAllFirstNames getAllFirstNames, InsertFirstName insertFirstName, DeleteFirstName deleteFirstName) {
        this.getAllFirstNames = getAllFirstNames;
        this.insertFirstName = insertFirstName;
        this.deleteFirstName = deleteFirstName;
    }

    @GetMapping(PREFIX)
	public CompletableFuture<List<FirstName>> list() {
		return this.getAllFirstNames.execute();
	}

	@PostMapping(PREFIX)
	public CompletableFuture<FirstName> insert(@RequestBody FirstName firstName) {
		return this.insertFirstName.execute(firstName);
	}

    @DeleteMapping(PREFIX + "/{id}")
    public CompletableFuture<FirstName> delete(@PathVariable long id) {
        return this.deleteFirstName.execute(id);
    }
}
