package me.choicore.springbootddd.presentation.rest.adapter.user.dto.response;

import lombok.Builder;
import me.choicore.springbootddd.presentation.rest.constant.GenderDto;

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
