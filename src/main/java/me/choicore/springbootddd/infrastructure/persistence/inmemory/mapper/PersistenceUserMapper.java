package me.choicore.springbootddd.infrastructure.persistence.inmemory.mapper;

import me.choicore.springbootddd.domain.user.model.*;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class PersistenceUserMapper {

    public Gender convertToGenderEntity(UserEntity.Gender domain) {
        if (domain == null) {
            return null; // 또는 기본값 처리를 원하는 값으로 변경
        }

        return Gender.of(domain.name());
    }

    public UserEntity.Gender convertToGenderDomain(Gender gender) {
        if (gender == null) {
            return null; // 또는 기본값 처리를 원하는 값으로 변경
        }

        return UserEntity.Gender.valueOf(gender.code());
    }

    public UserProfile fromEntity(UserEntity entity) {
        if (entity == null) return null;
        return new UserProfile(entity.getUuid()
                , entity.getUserId()
                , entity.getUsername()
                , entity.getNickname()
                , convertToGenderEntity(entity.getGender())
                , BirthDate.of(entity.getBirthDate())
                , entity.getCreatedAt()
        );
    }

    public List<UserProfile> fromEntities(List<UserEntity> entities) {
        return Optional.ofNullable(entities)
                       .stream()
                       .flatMap(List::stream)
                       .map(this::fromEntity)
                       .toList();

    }

    public UserEntity fromDomain(CreateUserProfile domain) {
        LocalDateTime now = LocalDateTime.now();
        return UserEntity.builder()
                         .username(domain.username())
                         .nickname(domain.nickname())
                         .gender(convertToGenderDomain(domain.gender()))
                         .createdAt(now)
                         .build();
    }

    public UserEntity fromDomain(ModifyUserProfile domain) {
        LocalDateTime now = LocalDateTime.now();
        return UserEntity.builder()
                         .userId(domain.userId())
                         .nickname(domain.nickname())
                         .modifiedAt(now)
                         .build();
    }

}
