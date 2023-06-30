package me.choicore.springbootddd.infrastructure.persistence.inmemory;

import me.choicore.springbootddd.domain.user.model.CreateUserProfile;
import me.choicore.springbootddd.domain.user.model.ModifyUserProfile;
import me.choicore.springbootddd.domain.user.model.QueryUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserProfilePort;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserProfilePort;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.mapper.PersistenceUserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;


@Repository
public class UserManagementInMemoryAdapter implements
        ModifyUserProfilePort
        , QueryUserProfilePort {

    private final InMemoryDb inMemoryDb;

    private final PersistenceUserMapper persistenceUserMapper;

    public UserManagementInMemoryAdapter(InMemoryDb inMemoryDb, PersistenceUserMapper persistenceUserMapper) {
        this.inMemoryDb = inMemoryDb;
        this.persistenceUserMapper = persistenceUserMapper;
    }

    @Override
    public UserProfile findById(Long userId) {
        return persistenceUserMapper.fromEntity(findUserById(userId));
    }

    @Override
    public List<UserProfile> findBy(QueryUserProfile user) {
        return inMemoryDb.values()
                         .stream()
                         .filter(matchesUser(user))
                         .map(persistenceUserMapper::fromEntity)
                         .toList();
    }

    @Override
    public List<UserProfile> findAll() {
        return persistenceUserMapper.fromEntities(inMemoryDb.values().stream().toList());
    }

    private Predicate<UserEntity> matchesUser(QueryUserProfile user) {
        return userEntity ->
                userEntity.getUserId().equals(user.userId())
                        || userEntity.getUsername().equals(user.username())
                        || userEntity.getNickname().equals(user.nickname())
                        || userEntity.getUuid().equals(user.uuid())
                        || Optional.ofNullable(userEntity.getBirthDate())
                                   .stream()
                                   .anyMatch(birthDate -> birthDate.getYear() == user.birthYear());
    }

    @Override
    public UserProfile createBy(CreateUserProfile user) {
        if (existsByUsername(user.username())) {
            throw new IllegalStateException("이미 존재하는 사용자입니다.");
        }
        Long generatedUserId = inMemoryDb.generateId();

        UserEntity userEntity = UserEntity.builder()
                                          .uuid(UUID.randomUUID())
                                          .userId(generatedUserId)
                                          .username(user.username())
                                          .nickname(user.nickname())
                                          .gender(persistenceUserMapper.convertToGenderDomain(user.gender()))
                                          .birthDate(user.birthDate().dayOfBirth())
                                          .build();

        inMemoryDb.put(generatedUserId, userEntity);

        return persistenceUserMapper.fromEntity(userEntity);
    }

    @Override
    public boolean existsByUsername(String username) {
        return alreadyExists(userEntity -> userEntity.getUsername().equals(username));
    }

    @Override
    public UserProfile modifyBy(ModifyUserProfile user) {
        UserEntity userEntity = findUserById(user.userId());
        userEntity.changeNickname(user.nickname());
        return persistenceUserMapper.fromEntity(userEntity);
    }

    @Override
    public void deleteById(Long userId) {
        if (!alreadyExists(userEntity -> userEntity.getUserId().equals(userId))) {
            throw new IllegalStateException("존재하지 않는 사용자입니다.");
        }
        inMemoryDb.remove(userId);
    }

    protected boolean alreadyExists(Predicate<UserEntity> userMatches) {
        return inMemoryDb.values()
                         .stream()
                         .anyMatch(userMatches);
    }

    private UserEntity findUserById(Long userId) {
        return Optional.ofNullable(inMemoryDb.get(userId)).orElseThrow(() -> new IllegalStateException("존재하지 않는 사용자입니다."));
    }

}
