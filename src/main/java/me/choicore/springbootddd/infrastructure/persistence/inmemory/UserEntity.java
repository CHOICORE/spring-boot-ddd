package me.choicore.springbootddd.infrastructure.persistence.inmemory;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Builder
@Getter
public class UserEntity {

    private UUID uuid;
    private Long userId;
    private String username;
    private String nickname;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public void changeNickname(String nickname) {
        this.nickname = nickname;
        this.modifiedAt = LocalDateTime.now();
    }

    /**
     * gender type code.
     */
    public enum Gender {
        M, F
    }

}
