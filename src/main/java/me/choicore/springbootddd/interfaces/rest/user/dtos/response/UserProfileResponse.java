package me.choicore.springbootddd.interfaces.rest.user.dtos.response;

import lombok.Builder;

import java.util.UUID;


public record UserProfileResponse(UUID id, String username, String nickname) {

    @Builder
    public UserProfileResponse {
    }
}
