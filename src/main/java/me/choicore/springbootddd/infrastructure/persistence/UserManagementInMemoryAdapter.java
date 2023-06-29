package me.choicore.springbootddd.infrastructure.persistence;

import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;
import me.choicore.springbootddd.domain.ports.out.CreateUserPort;
import me.choicore.springbootddd.domain.ports.out.DeleteUserPort;
import me.choicore.springbootddd.domain.ports.out.ModifyUserPort;
import me.choicore.springbootddd.domain.ports.out.UserProfilePort;
import me.choicore.springbootddd.infrastructure.persistence.mappers.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class UserManagementInMemoryAdapter implements
        CreateUserPort
        , UserProfilePort
        , ModifyUserPort
        , DeleteUserPort {
    private final Map<Long, UserEntity> store = new ConcurrentHashMap<>();
    private final UserMapper userMapper = new UserMapper();

    @Override
    public UserProfile findById(Long userId) {

        UserEntity userEntity = store.get(userId);

        Objects.requireNonNull(userEntity);

        return null;
    }

    @Override
    public UserProfile findBy(UserProfile user) {
        return null;
    }

    @Override
    public UserProfile createBy(CreateUserProfile user) {

        if (existsByUsername(user.username())) {
            throw new IllegalStateException("이미 존재하는 사용자입니다.");
        }
        Long generatedUserId = InMemoryAdapterUtils.generateId(store);

        UserEntity userEntity = UserEntity.builder()
                                          .uuid(UUID.randomUUID())
                                          .userId(generatedUserId)
                                          .username(user.username())
                                          .nickname(user.nickname())
                                          .build();

        store.put(generatedUserId, userEntity);

        return userMapper.fromEntity(userEntity);
    }

    @Override
    public boolean existsByUsername(String username) {
        return store.values()
                    .stream()
                    .filter(userEntity -> userEntity.getUsername().equals(username))
                    .anyMatch(obj -> true);
    }

    @Override
    public UserProfile modifyBy(UserProfile user) {
        return null;
    }

    @Override
    public void deleteBy(UserProfile user) {

    }

    @Override
    public void deleteById(Long userId) {
        if (!store.containsKey(userId)) {
            throw new IllegalStateException("존재하지 않는 유저입니다.");
        }
        store.remove(userId);
    }
}
