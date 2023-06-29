package me.choicore.springbootddd.infrastructure.persistence;

import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.ModifyUserProfile;
import me.choicore.springbootddd.domain.model.QueryUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;
import me.choicore.springbootddd.domain.ports.out.CreateUserPort;
import me.choicore.springbootddd.domain.ports.out.DeleteUserPort;
import me.choicore.springbootddd.domain.ports.out.ModifyUserPort;
import me.choicore.springbootddd.domain.ports.out.UserProfilePort;
import me.choicore.springbootddd.infrastructure.persistence.mappers.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;


@Repository
public class UserManagementInMemoryAdapter implements
        CreateUserPort
        , UserProfilePort
        , ModifyUserPort
        , DeleteUserPort {
    private final Map<Long, UserEntity> userRepository = new ConcurrentHashMap<>();
    private final UserMapper userMapper = new UserMapper();


    @Override
    public UserProfile findById(Long userId) {
        return userMapper.fromEntity(findUserById(userId));
    }


    @Override
    public List<UserProfile> findBy(QueryUserProfile user) {
        return userRepository.values()
                             .stream()
                             .filter(matchesUser(user))
                             .map(userMapper::fromEntity)
                             .toList();
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
        Long generatedUserId = InMemoryAdapterUtils.generateId(userRepository);

        UserEntity userEntity = UserEntity.builder()
                                          .uuid(UUID.randomUUID())
                                          .userId(generatedUserId)
                                          .username(user.username())
                                          .nickname(user.nickname())
                                          .birthDate(user.birthDate().dayOfBirth())
                                          .build();

        userRepository.put(generatedUserId, userEntity);

        return userMapper.fromEntity(userEntity);
    }

    @Override
    public boolean existsByUsername(String username) {
        return alreadyExists(userEntity -> userEntity.getUsername().equals(username));
    }

    @Override
    public UserProfile modifyBy(ModifyUserProfile user) {
        UserEntity userEntity = findUserById(user.userId());
        userEntity.changeNickname(user.nickname());
        return userMapper.fromEntity(userEntity);
    }


    @Override
    public void deleteById(Long userId) {
        if (!alreadyExists(userEntity -> userEntity.getUserId().equals(userId))) {
            throw new IllegalStateException("존재하지 않는 사용자입니다.");
        }
        userRepository.remove(userId);
    }

    protected boolean alreadyExists(Predicate<UserEntity> predicate) {
        return userRepository.values()
                             .stream()
                             .anyMatch(predicate);
    }

    private UserEntity findUserById(Long userId) {
        return Optional.ofNullable(userRepository.get(userId)).orElseThrow(() -> new IllegalStateException("존재하지 않는 사용자입니다."));
    }
}
