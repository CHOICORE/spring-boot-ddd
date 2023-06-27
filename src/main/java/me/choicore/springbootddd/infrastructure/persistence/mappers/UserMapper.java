package me.choicore.springbootddd.infrastructure.persistence.mappers;

import me.choicore.springbootddd.domain.model.BirthDate;
import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;
import me.choicore.springbootddd.infrastructure.persistence.UserEntity;

import java.time.LocalDateTime;


public class UserMapper {
    public UserProfile fromEntity(UserEntity entity) {


        return new UserProfile(entity.getUuid()
                , entity.getUserId()
                , entity.getUsername()
                , entity.getNickname()
                , BirthDate.of(entity.getBirthDate())
        );

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
