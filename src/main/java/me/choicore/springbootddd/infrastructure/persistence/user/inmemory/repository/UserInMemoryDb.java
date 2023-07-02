package me.choicore.springbootddd.infrastructure.persistence.user.inmemory.repository;

import me.choicore.springbootddd.infrastructure.persistence.user.inmemory.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;


@Repository
public class UserInMemoryDb extends InMemoryDb<UserEntity, Long> {

    public UserInMemoryDb() {
        super();
    }

    public static UserInMemoryDb setUpMock() {
        UserInMemoryDb inMemoryDb = new UserInMemoryDb();
        inMemoryDb.setup();
        return inMemoryDb;
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public UserEntity get(final Long userId) {
        return super.get(userId);
    }

    @Override
    public void put(final Long currentId, final UserEntity entity) {
        super.put(currentId, entity);
    }

    @Override
    public void remove(final Long userId) {
        super.remove(userId);
    }

    @Override
    public Collection<UserEntity> values() {
        return super.values();
    }


    @Override
    public Long generateId() {
        return values().stream()
                       .map(UserEntity::userId)
                       .max(Long::compare)
                       .orElse(0L) + 1;
    }

    private void setup() {

        long userId = 1L;
        UserEntity userEntity = UserEntity.builder()
                                          .uuid(UUID.randomUUID())
                                          .userId(userId)
                                          .firstName("재형")
                                          .lastName("최")
                                          .nickname("choicore")
                                          .gender(UserEntity.Gender.M)
                                          .birthDate(LocalDate.of(1993, 9, 22))
                                          .createdAt(LocalDateTime.now())
                                          .modifiedAt(null)
                                          .build();

        super.put(userId, userEntity);
    }
}
