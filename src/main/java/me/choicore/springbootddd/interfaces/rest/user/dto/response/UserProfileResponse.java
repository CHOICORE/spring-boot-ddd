package me.choicore.springbootddd.interfaces.rest.user.dto.response;

import lombok.Builder;
import me.choicore.springbootddd.interfaces.enums.GenderType;

import java.util.UUID;


public record UserProfileResponse(
        UUID id
        , String email
        , String firstName
        , String lastName
        , String nickname
        , GenderType gender
        , BirthDateResponse birthDate) {

    @Builder
    public UserProfileResponse {
    }

}
