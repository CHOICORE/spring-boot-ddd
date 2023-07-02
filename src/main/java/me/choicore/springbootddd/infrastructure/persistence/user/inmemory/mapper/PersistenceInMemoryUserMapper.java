package me.choicore.springbootddd.infrastructure.persistence.user.inmemory.mapper;

import me.choicore.springbootddd.domain.user.model.*;
import me.choicore.springbootddd.infrastructure.persistence.user.inmemory.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class PersistenceInMemoryUserMapper {

    public Gender convertToGenderEntity(final UserEntity.Gender domain) {
        if (domain == null) {
            return null;
        }

        return Gender.of(domain.name());
    }

    public UserEntity.Gender convertToGenderDomain(final Gender gender) {
        if (gender == null) {
            return null;
        }

        return UserEntity.Gender.valueOf(gender.code());
    }

    public UserProfile fromEntity(final UserEntity entity) {
        if (entity == null) return null;
        return new UserProfile(
                entity.uuid()
                , entity.userId()
                , entity.email()
                , entity.password()
                , FullName.of(entity.firstName(), entity.lastName())
                , entity.nickname()
                , convertToGenderEntity(entity.gender())
                , BirthDate.of(entity.birthDate())
                , entity.createdAt()
        );
    }

    public List<UserProfile> fromEntities(final List<UserEntity> entities) {
        return Optional.ofNullable(entities)
                       .stream()
                       .flatMap(List::stream)
                       .map(this::fromEntity)
                       .toList();

    }

    public UserEntity fromDomain(final CreateUserProfile domain) {
        LocalDateTime now = LocalDateTime.now();
        return UserEntity.builder()
                         .firstName(domain.fullName().firstName())
                         .lastName(domain.fullName().lastName())
                         .nickname(domain.nickname())
                         .gender(convertToGenderDomain(domain.gender()))
                         .createdAt(now)
                         .build();
    }

    public UserEntity fromDomain(final ModifyUserProfile domain) {
        LocalDateTime now = LocalDateTime.now();
        return UserEntity.builder()
                         .userId(domain.userId())
                         .nickname(domain.nickname())
                         .modifiedAt(now)
                         .build();
    }

}
