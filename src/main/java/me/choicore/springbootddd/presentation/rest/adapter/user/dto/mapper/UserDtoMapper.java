package me.choicore.springbootddd.presentation.rest.adapter.user.dto.mapper;

import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.model.BirthDate;
import me.choicore.springbootddd.domain.user.model.Gender;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import me.choicore.springbootddd.presentation.rest.adapter.user.dto.request.CreateUserRequestDto;
import me.choicore.springbootddd.presentation.rest.adapter.user.dto.response.BirthDateResponseDto;
import me.choicore.springbootddd.presentation.rest.adapter.user.dto.response.UserProfileResponseDto;
import me.choicore.springbootddd.presentation.rest.constant.GenderDto;
import org.springframework.stereotype.Component;


@Component
public class UserDtoMapper {

    public CreateProfile toDomain(final CreateUserRequestDto request) {
        return new CreateProfile(
                request.email()
                , request.password()
                , Username.of(request.firstName(), request.lastName())
                , request.nickname()
                , Gender.of(request.genderDto().name())
                , BirthDate.of(request.birthDate()));
    }

    public UserProfileResponseDto fromDomain(final UserProfile domain) {
        return UserProfileResponseDto.builder()
                                     .id(domain.uuid())
                                     .email(domain.email())
                                     .firstName(domain.username().firstName())
                                     .lastName(domain.username().lastName())
                                     .nickname(domain.nickname())
                                     .genderDto(GenderDto.valueOf(domain.gender().code()))
                                     .birthDate(BirthDateResponseDto.of(domain.birthDate()))
                                     .build();
    }

}