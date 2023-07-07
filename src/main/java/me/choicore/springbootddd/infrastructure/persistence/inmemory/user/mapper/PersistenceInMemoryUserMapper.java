package me.choicore.springbootddd.infrastructure.persistence.inmemory.user.mapper;

import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.command.ModifyProfile;
import me.choicore.springbootddd.domain.user.model.BirthDate;
import me.choicore.springbootddd.domain.user.model.Gender;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static me.choicore.springbootddd.domain.user.model.Gender.FEMALE;
import static me.choicore.springbootddd.domain.user.model.Gender.MALE;


@Component
public class PersistenceInMemoryUserMapper {

    public Gender toGenderDomain(final UserEntity.Gender genderEntity) {
        return switch (genderEntity) {
            case M -> MALE;
            case F -> FEMALE;
        };
    }

    public UserEntity.Gender toGenderEntity(final Gender gender) {
        return switch (gender) {
            case MALE -> UserEntity.Gender.M;
            case FEMALE -> UserEntity.Gender.F;
        };
    }

    public UserProfile fromEntity(final UserEntity entity) {
        if (entity == null) return null;
        return new UserProfile(
                entity.uuid()
                , entity.userId()
                , entity.email()
                , entity.password()
                , Username.of(entity.firstName(), entity.lastName())
                , entity.nickname()
                , toGenderDomain(entity.gender())
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

    public UserEntity fromDomain(final CreateProfile domain) {
        return UserEntity.builder()
                         .email(domain.email())
                         .password(domain.password())
                         .firstName(domain.username().firstName())
                         .lastName(domain.username().lastName())
                         .nickname(domain.nickname())
                         .gender(toGenderEntity(domain.gender()))
                         .birthDate(domain.birthDate().dateOfBirth())
                         .build();
    }

    public UserEntity fromDomain(final ModifyProfile domain) {
        LocalDateTime now = LocalDateTime.now();
        return UserEntity.builder()
                         .userId(domain.userId())
                         .nickname(domain.nickname())
                         .modifiedAt(now)
                         .build();
    }

}
