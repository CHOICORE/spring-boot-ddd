package me.choicore.springbootddd.infrastructure.persistence;

import java.util.Map;

public class InMemoryAdapterUtils {
    public static Long generateId(Map<Long, ?> store) {
        return store.keySet()
                    .stream()
                    .max(Long::compare)
                    .orElse(0L) + 1;
    }
}
