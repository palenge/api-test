package com.example.restservice.adapters.repositories;

import com.example.restservice.domain.FirstName;
import com.example.restservice.domain.repositories.FirstNameRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

@Repository
public class FirstNameMemoryRepository implements FirstNameRepository {

    private AtomicLong autoIncrement;
    private List<FirstName> firstNames;
    private Random rand;

    public FirstNameMemoryRepository() {
        rand = new Random();
        autoIncrement = new AtomicLong();
        firstNames = new ArrayList<>();
        FirstName fnames = new FirstName();
        fnames.setFirstName("Fernando");
        insert(fnames);
    }

    @Override
    public CompletableFuture<FirstName> get(long id) {
        return CompletableFuture.supplyAsync(() -> {
            int index = findById(id);
            if (index > 0) {
                return this.firstNames.get(index);
            } else {
                return null;
            }
        });
    }

    @Override
    public CompletableFuture<FirstName> getRandom() {
        return CompletableFuture.supplyAsync(() -> {
            if (this.firstNames.size() > 0) {
                return this.firstNames.get(rand.nextInt(this.firstNames.size()));
            }

            return null;
        });
    }

    @Override
    public CompletableFuture<FirstName> insert(FirstName value) {
        return CompletableFuture.supplyAsync(() -> {
            if (containsName(this.firstNames, value.getFirstName())) {
                throw null;
            } else {
                this.firstNames.add(value);
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
                this.firstNames.remove(index);
            }
            return null;
        });
    }

    @Override
    public CompletableFuture<List<FirstName>> findAll() {
        return CompletableFuture.supplyAsync(() -> this.firstNames);
    }

    private boolean containsName(final List<FirstName> list, final String name) {
        return list.stream().anyMatch(o -> o.getFirstName().equals(name));
    }

    private int findById(long id) {
        return IntStream.range(0, this.firstNames.size())
                .filter(i -> this.firstNames.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }
}
