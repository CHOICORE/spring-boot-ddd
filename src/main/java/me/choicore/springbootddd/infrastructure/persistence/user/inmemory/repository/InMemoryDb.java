package me.choicore.springbootddd.infrastructure.persistence.user.inmemory.repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * in-memory database mock.
 * <p>
 */
public abstract class InMemoryDb<T, R> {

    private final Map<R, T> inMemoryDb;
    private R currentId;

    public InMemoryDb() {
        this.inMemoryDb = new ConcurrentHashMap<>();
    }

    public int size() {
        return inMemoryDb.size();
    }

    public T get(R userId) {
        return inMemoryDb.get(userId);
    }

    public void put(R currentId, T entity) {
        inMemoryDb.put(currentId, entity);
    }

    public void remove(R userId) {
        inMemoryDb.remove(userId);
    }

    public Collection<T> values() {
        return inMemoryDb.values();
    }

    public abstract R generateId();


}
