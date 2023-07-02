package me.choicore.springbootddd.infrastructure.persistence.user.inmemory;

import me.choicore.springbootddd.domain.user.model.CreateUserProfile;
import me.choicore.springbootddd.domain.user.model.ModifyUserProfile;
import me.choicore.springbootddd.domain.user.model.QueryUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserPort;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserPort;
import me.choicore.springbootddd.infrastructure.persistence.user.inmemory.entity.UserEntity;
import me.choicore.springbootddd.infrastructure.persistence.user.inmemory.mapper.PersistenceInMemoryUserMapper;
import me.choicore.springbootddd.infrastructure.persistence.user.inmemory.repository.UserInMemoryDb;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;


@Repository
public class UserManagementInMemoryAdapter implements
        ModifyUserPort
        , QueryUserPort {

    private final UserInMemoryDb userInMemoryDb;

    private final PersistenceInMemoryUserMapper persistenceInMemoryUserMapper;

    public UserManagementInMemoryAdapter(final UserInMemoryDb userInMemoryDb, final PersistenceInMemoryUserMapper persistenceInMemoryUserMapper) {
        this.userInMemoryDb = userInMemoryDb;
        this.persistenceInMemoryUserMapper = persistenceInMemoryUserMapper;
    }

    @Override
    public UserProfile findById(final Long userId) {
        return persistenceInMemoryUserMapper.fromEntity(findUserById(userId));
    }

    @Override
    public List<UserProfile> findBy(final QueryUserProfile user) {
        return userInMemoryDb.values()
                             .stream()
                             .filter(matchesUser(user))
                             .map(persistenceInMemoryUserMapper::fromEntity)
                             .toList();
    }

    @Override
    public List<UserProfile> findAll() {
        return persistenceInMemoryUserMapper.fromEntities(userInMemoryDb.values().stream().toList());
    }

    private Predicate<UserEntity> matchesUser(final QueryUserProfile user) {
        return userEntity ->
                userEntity.userId().equals(user.userId())
                        //|| userEntity.username().equals(user.username())
                        || userEntity.nickname().equals(user.nickname())
                        || userEntity.uuid().equals(user.uuid())
                        || Optional.ofNullable(userEntity.birthDate())
                                   .stream()
                                   .anyMatch(birthDate -> birthDate.getYear() == user.birthYear());
    }

    @Override
    public UserProfile createBy(final CreateUserProfile user) {
        if (existsByUsername(user.fullName().fullName())) {
            throw new IllegalStateException("이미 존재하는 사용자입니다.");
        }
        Long generatedUserId = userInMemoryDb.generateId();


        UserEntity userEntity = UserEntity.builder()
                                          .uuid(UUID.randomUUID())
                                          .userId(generatedUserId)
                                          .firstName(user.fullName().firstName())
                                          .lastName(user.fullName().lastName())
                                          .nickname(user.nickname())
                                          .gender(persistenceInMemoryUserMapper.convertToGenderDomain(user.gender()))
                                          .birthDate(user.birthDate().dayOfBirth())
                                          .build();

        userInMemoryDb.put(generatedUserId, userEntity);

        return persistenceInMemoryUserMapper.fromEntity(userEntity);
    }

    @Override
    public boolean existsByUsername(final String username) {
        return alreadyExists(userEntity -> userEntity.fullName().equals(username));
    }

    @Override
    public UserProfile modifyBy(final ModifyUserProfile user) {
        UserEntity userEntity = findUserById(user.userId());
        UserEntity modifedUserEntity = userEntity.changeNickname(user.nickname());
        return persistenceInMemoryUserMapper.fromEntity(modifedUserEntity);
    }

    @Override
    public void deleteById(final Long userId) {
        if (!alreadyExists(userEntity -> userEntity.userId().equals(userId))) {
            throw new IllegalStateException("존재하지 않는 사용자입니다.");
        }
        userInMemoryDb.remove(userId);
    }

    protected boolean alreadyExists(Predicate<UserEntity> userMatches) {
        return userInMemoryDb.values()
                             .stream()
                             .anyMatch(userMatches);
    }

    private UserEntity findUserById(final Long userId) {
        return Optional.ofNullable(userInMemoryDb.get(userId)).orElseThrow(() -> new IllegalStateException("존재하지 않는 사용자입니다."));
    }

}
