package me.choicore.springbootddd.infrastructure.persistence.inmemory;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

/**
 * <p>
 * in-memory database.
 * <p>
 */
public abstract class InMemoryDb<T extends InMemoryEntity<R>, R> {

    private final Map<R, T> inMemoryDb;

    public InMemoryDb() {
        this.inMemoryDb = new ConcurrentHashMap<>();
    }

    protected List<T> find(final Predicate<T> predicate) {
        return this.inMemoryDb.values().stream().filter(predicate).toList();
    }

    public boolean exists(final Predicate<T> predicate) {
        return this.inMemoryDb.values().stream().anyMatch(predicate);
    }

    public List<T> findAll() {
        return this.inMemoryDb.values().stream().toList();
    }

    public T findById(R userId) {
        return inMemoryDb.get(userId);
    }


    public T save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("entity is null");
        }
        inMemoryDb.put(entity.id(), entity);
        return entity;
    }

    public void deleteById(R userId) {
        inMemoryDb.remove(userId);
    }

    protected Collection<T> values() {
        return inMemoryDb.values();
    }

    public abstract R generateId();

}
