package me.choicore.springbootddd.infrastructure.persistence.user.inmemory;

import me.choicore.springbootddd.domain.user.model.QueryUserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;


@Repository
public class UserInMemoryDb extends InMemoryDb<UserEntity, Long> {

    public UserInMemoryDb() {
        super();
    }

    public static UserInMemoryDb testInstance() {
        UserInMemoryDb inMemoryDb = new UserInMemoryDb();
        inMemoryDb.testingMock();
        return inMemoryDb;
    }

    @Override
    public UserEntity findById(final Long userId) {
        return super.findById(userId);
    }

    public List<UserEntity> find(final QueryUserProfile user) {
        return super.find(matches(user));
    }

    @Override
    public UserEntity save(final UserEntity entity) {
        if (entity.userId() != null) {
            return super.save(entity);
        } else {
            UserEntity createUser = UserEntity.withGenerateUuid()
                                              .userId(generateId())
                                              .password(entity.password())
                                              .email(entity.email())
                                              .firstName(entity.firstName())
                                              .lastName(entity.lastName())
                                              .nickname(entity.nickname())
                                              .gender(entity.gender())
                                              .birthDate(entity.birthDate())
                                              .build();
            return super.save(createUser);
        }
    }

    @Override
    public void deleteById(final Long userId) {
        super.deleteById(userId);
    }

    @Override
    public Long generateId() {
        return values().stream()
                       .map(UserEntity::userId)
                       .max(Long::compare)
                       .orElse(0L) + 1;
    }

    private void testingMock() {
        UserEntity userEntity = UserEntity.withGenerateUuid()
                                          .userId(generateId())
                                          .email("admin")
                                          .password("admin")
                                          .firstName("재형")
                                          .lastName("최")
                                          .nickname("choicore")
                                          .gender(UserEntity.Gender.M)
                                          .birthDate(LocalDate.of(1993, 9, 22))
                                          .createdAt(LocalDateTime.now())
                                          .modifiedAt(null)
                                          .build();
        super.save(userEntity);
    }


    private Predicate<UserEntity> matches(final QueryUserProfile user) {
        return userEntity ->
                matchesId(user.userId()).test(userEntity)
                        || matchesUsername(user.username()).test(userEntity)
                        || matchesNickname(user.nickname()).test(userEntity)
                        || matchesUuid(user.uuid()).test(userEntity)
                        || matchesBirthYear(user.birthYear()).test(userEntity);
    }

    private Predicate<UserEntity> matchesId(final Long userId) {
        if (userId == null) return userEntity -> false;
        return userEntity -> userEntity.userId().equals(userId);
    }

    private Predicate<UserEntity> matchesUuid(final UUID uuid) {
        if (uuid == null) return userEntity -> false;
        return userEntity -> userEntity.uuid().equals(uuid);
    }

    private Predicate<UserEntity> matchesNickname(final String nickname) {
        if (nickname == null || nickname.isBlank()) return userEntity -> false;
        return userEntity -> userEntity.nickname().equals(nickname);
    }


    private Predicate<UserEntity> matchesBirthYear(final int birthYear) {
        if (birthYear == 0) return userEntity -> false;
        return userEntity -> Optional.ofNullable(userEntity.birthDate())
                                     .stream()
                                     .anyMatch(birthDate -> birthDate.getYear() == birthYear);
    }

    private Predicate<UserEntity> matchesUsername(final Username username) {
        if (username == null) return userEntity -> false;
        return userEntity -> userEntity.firstName().equals(username.firstName()) && userEntity.lastName().equals(username.lastName());
    }
}
