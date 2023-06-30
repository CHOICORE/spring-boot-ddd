package me.choicore.springbootddd.infrastructure.persistence.inmemory.mapper;

import me.choicore.springbootddd.domain.user.model.BirthDate;
import me.choicore.springbootddd.domain.user.model.CreateUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class UserMapper {

    public UserProfile fromEntity(UserEntity entity) {
        if (entity == null) return null;
        return new UserProfile(entity.getUuid()
                , entity.getUserId()
                , entity.getUsername()
                , entity.getNickname()
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
                         .createdAt(now)
                         .modifiedAt(now)
                         .build();
    }
}
