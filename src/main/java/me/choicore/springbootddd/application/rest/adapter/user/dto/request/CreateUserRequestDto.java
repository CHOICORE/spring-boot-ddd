package me.choicore.springbootddd.application.rest.adapter.user.dto.request;

import lombok.Builder;
import me.choicore.springbootddd.application.rest.constant.GenderDto;

import java.time.LocalDate;


public record CreateUserRequestDto(
        String email
        , String password
        , String firstName
        , String lastName
        , String nickname
        , GenderDto genderDto
        , LocalDate birthDate
) {
    @Builder
    public CreateUserRequestDto {
    }

}
