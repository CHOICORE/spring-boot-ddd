package me.choicore.springbootddd.application.rest.adapter.user.dto.request;

import lombok.Builder;
import me.choicore.springbootddd.application.rest.constant.GenderType;

import java.time.LocalDate;


public record CreateUserRequest(
        String email
        , String password
        , String firstName
        , String lastName
        , String nickname
        , GenderType gender
        , LocalDate birthDate
) {
    @Builder
    public CreateUserRequest {
    }

}
