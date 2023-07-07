package me.choicore.springbootddd.application.rest.adapter.user.dto.response;

import lombok.Builder;
import me.choicore.springbootddd.application.rest.constant.GenderDto;

import java.util.UUID;


public record UserProfileResponseDto(
        UUID id
        , String email
        , String firstName
        , String lastName
        , String nickname
        , GenderDto genderDto
        , BirthDateResponseDto birthDate) {

    @Builder
    public UserProfileResponseDto {
    }

}
