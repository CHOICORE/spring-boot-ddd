package me.choicore.springbootddd.interfaces.rest.user.dtos.request;

import lombok.Builder;

import java.time.LocalDate;


public record CreateUserRequest(
        String username
        , String nickname
        , LocalDate birthDate
) {
    @Builder
    public CreateUserRequest {
    }
}
