package me.choicore.springbootddd.interfaces.rest.user.dto.request;

import lombok.Builder;
import me.choicore.springbootddd.interfaces.enums.GenderType;

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
