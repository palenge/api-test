package com.example.restservice.adapters.controllers;

import com.example.restservice.domain.LastName;
import com.example.restservice.use_cases.DeleteLastName;
import com.example.restservice.use_cases.GetAllLastNames;
import com.example.restservice.use_cases.InsertLastName;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@CrossOrigin(origins = "*")
@RestController
public class LastNameController {

    private final String PREFIX = "/last_name";
	private final GetAllLastNames getAllLastNames;
    private final InsertLastName insertLastName;
    private final DeleteLastName deleteLastName;

    public LastNameController(GetAllLastNames getAllLastNames, InsertLastName insertLastName, DeleteLastName deleteLastName) {
        this.getAllLastNames = getAllLastNames;
        this.insertLastName = insertLastName;
        this.deleteLastName = deleteLastName;
    }

    @GetMapping(PREFIX)
	public CompletableFuture<List<LastName>> list() {
		return this.getAllLastNames.execute();
	}

	@PostMapping(PREFIX)
	public CompletableFuture<LastName> insert(@RequestBody LastName LastName) {
		return this.insertLastName.execute(LastName);
	}

    @DeleteMapping(PREFIX + "/{id}")
    public CompletableFuture<LastName> delete(@PathVariable long id) {
        return this.deleteLastName.execute(id);
    }
}
