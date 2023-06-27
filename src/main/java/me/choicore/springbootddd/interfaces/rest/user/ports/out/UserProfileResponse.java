package me.choicore.springbootddd.interfaces.rest.user.ports.out;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;


public class UserProfileResponse {

    @Getter
    private final UUID id;

    @Getter
    private final String nickname;

    @Getter
    private final String username;


    @Builder
    public UserProfileResponse(UUID id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }
}
