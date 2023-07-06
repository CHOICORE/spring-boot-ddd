package me.choicore.springbootddd.infrastructure.persistence.inmemory.user;

import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.command.ModifyProfile;
import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserDrivenPort;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserDrivenPort;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.mapper.PersistenceInMemoryUserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


@Repository
public class UserManagementInMemoryAdapterDrivenDriven implements
        ModifyUserDrivenPort
        , QueryUserDrivenPort {

    private final UserInMemoryDb userInMemoryDb;

    private final PersistenceInMemoryUserMapper persistenceInMemoryUserMapper;

    public UserManagementInMemoryAdapterDrivenDriven(final UserInMemoryDb userInMemoryDb, final PersistenceInMemoryUserMapper persistenceInMemoryUserMapper) {
        this.userInMemoryDb = userInMemoryDb;
        this.persistenceInMemoryUserMapper = persistenceInMemoryUserMapper;
    }

    @Override
    public UserProfile findById(final Long userId) {
        return persistenceInMemoryUserMapper.fromEntity(findUserById(userId));
    }

    @Override
    public List<UserProfile> findByUserProfile(final QueryProfile user) {
        return persistenceInMemoryUserMapper.fromEntities(userInMemoryDb.find(user));

    }

    @Override
    public List<UserProfile> findAll() {
        return persistenceInMemoryUserMapper.fromEntities(userInMemoryDb.findAll());
    }


    @Override
    public UserProfile createBy(final CreateProfile user) {
        if (existsByUsername(user.username().firstName(), user.username().lastName())) {
            throw new IllegalStateException("이미 존재하는 사용자입니다.");
        }
        UserEntity userEntity = persistenceInMemoryUserMapper.fromDomain(user);
        UserEntity savedUserEntity = userInMemoryDb.save(userEntity);
        return persistenceInMemoryUserMapper.fromEntity(savedUserEntity);
    }

    @Override
    public boolean existsByUsername(final Username username) {
        return existsByUsername(username.firstName(), username.lastName());
    }

    private boolean existsByUsername(final String firstName, final String lastName) {
        return alreadyExists(userEntity ->
                lastName.equals(userEntity.lastName())
                        && firstName.equals(userEntity.firstName())
        );
    }

    @Override
    public UserProfile modifyBy(final ModifyProfile user) {
        UserEntity userEntity = findUserById(user.userId());
        UserEntity modifedUserEntity = userEntity.changeNickname(user.nickname());
        return persistenceInMemoryUserMapper.fromEntity(modifedUserEntity);
    }

    @Override
    public void deleteById(final Long userId) {
        if (!alreadyExists(userEntity -> userEntity.userId().equals(userId))) {
            throw new IllegalStateException("존재하지 않는 사용자입니다.");
        }
        userInMemoryDb.deleteById(userId);
    }

    protected boolean alreadyExists(Predicate<UserEntity> userMatches) {
        return userInMemoryDb.exists(userMatches);
    }

    private UserEntity findUserById(final Long userId) {
        return Optional.ofNullable(userInMemoryDb.findById(userId)).orElseThrow(() -> new IllegalStateException("존재하지 않는 사용자입니다."));
    }

}
