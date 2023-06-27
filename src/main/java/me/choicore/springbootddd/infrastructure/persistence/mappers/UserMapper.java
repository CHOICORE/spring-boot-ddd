package me.choicore.springbootddd.infrastructure.persistence.mappers;

import me.choicore.springbootddd.domain.model.CreateUser;
import me.choicore.springbootddd.infrastructure.persistence.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;


public class UserMapper {

    private UUID uuid;

    private Long userId;

    private String username;

    private String nickname;


    public CreateUser fromEntity(UserEntity entity) {
        return CreateUser.builder()
                         .username(entity.getUsername())
                         .nickname(entity.getNickname())
                         .build();
    }

    public UserEntity fromDomain(CreateUser domain) {
        LocalDateTime now = LocalDateTime.now();
        return UserEntity.builder()
                         .username(domain.getUsername())
                         .nickname(domain.getNickname())
                         .createdAt(now)
                         .modifiedAt(now)
                         .build();
    }

}
