package me.choicore.springbootddd.infrastructure.persistence.inmemory;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * in-memory database mock.
 * <p>
 */
@Component
public class InMemoryDb {

    private final Map<Long, UserEntity> inMemoryDb;
    private Long currentId;

    public InMemoryDb() {
        this.currentId = 0L;
        this.inMemoryDb = new ConcurrentHashMap<>();
    }

    public static InMemoryDb setupTestModule() {
        InMemoryDb inMemoryDb = new InMemoryDb();
        inMemoryDb.setup();
        return inMemoryDb;
    }

    public int size() {
        return inMemoryDb.size();
    }

    public UserEntity get(Long userId) {
        return inMemoryDb.get(userId);
    }

    public void put(Long userId, UserEntity userEntity) {
        inMemoryDb.put(userId, userEntity);
    }

    public void remove(Long userId) {
        inMemoryDb.remove(userId);
    }

    public Collection<UserEntity> values() {
        return inMemoryDb.values();
    }

    public Long generateId() {
        return this.currentId++;
//        return inMemoryDb.keySet()
//                         .stream()
//                         .max(Long::compare)
//                         .orElse(0L) + 1;
    }


    private void setup() {

        long userId = 1L;
        UserEntity userEntity = UserEntity.builder()
                                          .uuid(UUID.randomUUID())
                                          .userId(userId)
                                          .username("최재형")
                                          .nickname("choicore")
                                          .birthDate(LocalDate.of(1993, 9, 22))
                                          .createdAt(LocalDateTime.now())
                                          .modifiedAt(null)
                                          .build();

        inMemoryDb.put(userId, userEntity);
//
//        Stream.iterate(1, i -> i + 1)
//              .limit(1)
//              .forEach(i -> {
//                  UserEntity userEntity = UserEntity.builder()
//                                                    .uuid(UUID.randomUUID())
//                                                    .userId((long) i)
//                                                    .username("test" + i)
//                                                    .nickname("test" + i)
//                                                    .birthDate(LocalDate.of(1990, 1, i))
//                                                    .createdAt(LocalDateTime.now())
//                                                    .modifiedAt(null)
//                                                    .build();
//
//                  userRepository.put((long) i, userEntity);
//              });
    }
}
