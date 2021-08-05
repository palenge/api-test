package com.example.restservice.adapters.repositories;

import com.example.restservice.domain.LastName;
import com.example.restservice.domain.repositories.LastNameRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

@Repository
public class LastNameMemoryRepository implements LastNameRepository {

    private AtomicLong autoIncrement;
    private List<LastName> lastNames;
    private Random rand;

    public LastNameMemoryRepository() {
        rand = new Random();
        autoIncrement = new AtomicLong();
        lastNames = new ArrayList<>();
        LastName fnames = new LastName();
        fnames.setLastName("Alvarez");
        insert(fnames);
    }

    @Override
    public CompletableFuture<LastName> getRandom() {
        return CompletableFuture.supplyAsync(() -> {
            if (this.lastNames.size() > 0) {
                return this.lastNames.get(rand.nextInt(this.lastNames.size()));
            }

            return null;
        });
    }

    @Override
    public CompletableFuture<LastName> get(long id) {
        return CompletableFuture.supplyAsync(() -> {
            int index = findById(id);
            if (index > 0) {
                return this.lastNames.get(index);
            } else {
                return null;
            }
        });
    }

    @Override
    public CompletableFuture<LastName> insert(LastName value) {
        return CompletableFuture.supplyAsync(() -> {
            if (containsName(this.lastNames, value.getLastName())) {
                return null;
            } else {
                this.lastNames.add(value);
                value.setId(autoIncrement.incrementAndGet());
                return value;
            }
        });
    }

    @Override
    public CompletableFuture delete(long id) {
        return CompletableFuture.supplyAsync(() -> {
            int index = findById(id);
            if (index >= 0) {
                this.lastNames.remove(index);
            }
            return null;
        });
    }

    @Override
    public CompletableFuture<List<LastName>> findAll() {
        return CompletableFuture.supplyAsync(() -> this.lastNames);
    }

    private boolean containsName(final List<LastName> list, final String name) {
        return list.stream().anyMatch(o -> o.getLastName().equals(name));
    }

    private int findById(long id) {
        return IntStream.range(0, this.lastNames.size())
                .filter(i -> this.lastNames.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }
}
