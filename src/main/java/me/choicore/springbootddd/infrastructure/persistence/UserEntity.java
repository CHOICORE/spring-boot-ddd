package me.choicore.springbootddd.infrastructure.persistence;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;


@Builder
@Getter
public class UserEntity {

    private UUID uuid;
    private Long userId;
    private String username;
    private String nickname;


    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    protected void setUserId(Long userId) {
        this.userId = userId;
    }

}
