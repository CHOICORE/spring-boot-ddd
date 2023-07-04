package me.choicore.springbootddd.application.rest.user.dto.mapper;

import me.choicore.springbootddd.application.rest.constant.GenderType;
import me.choicore.springbootddd.application.rest.user.dto.request.CreateUserRequest;
import me.choicore.springbootddd.application.rest.user.dto.response.BirthDateResponse;
import me.choicore.springbootddd.application.rest.user.dto.response.UserProfileResponse;
import me.choicore.springbootddd.domain.user.command.CreateUserProfile;
import me.choicore.springbootddd.domain.user.model.BirthDate;
import me.choicore.springbootddd.domain.user.model.Gender;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import org.springframework.stereotype.Component;


@Component
public class PresentationUserMapper {

    public CreateUserProfile toDomain(final CreateUserRequest request) {
        return new CreateUserProfile(
                request.email()
                , request.password()
                , Username.of(request.firstName(), request.lastName())
                , request.nickname()
                , Gender.of(request.gender().name())
                , BirthDate.of(request.birthDate()));
    }

    public UserProfileResponse fromDomain(final UserProfile domain) {
        return UserProfileResponse.builder()
                                  .id(domain.uuid())
                                  .email(domain.email())
                                  .firstName(domain.username().firstName())
                                  .lastName(domain.username().lastName())

                                  .nickname(domain.nickname())
                                  .gender(GenderType.valueOf(domain.gender().code()))
                                  .birthDate(BirthDateResponse.of(domain.birthDate()))
                                  .build();
    }

}
