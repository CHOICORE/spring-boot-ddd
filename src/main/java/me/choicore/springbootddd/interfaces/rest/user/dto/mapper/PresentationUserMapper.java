package me.choicore.springbootddd.interfaces.rest.user.dto.mapper;

import me.choicore.springbootddd.domain.user.model.BirthDate;
import me.choicore.springbootddd.domain.user.model.CreateUserProfile;
import me.choicore.springbootddd.domain.user.model.Gender;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.interfaces.enums.GenderType;
import me.choicore.springbootddd.interfaces.rest.user.dto.request.CreateUserRequest;
import me.choicore.springbootddd.interfaces.rest.user.dto.response.BirthDateResponse;
import me.choicore.springbootddd.interfaces.rest.user.dto.response.UserProfileResponse;
import org.springframework.stereotype.Component;


@Component
public class PresentationUserMapper {

    public CreateUserProfile toDomain(final CreateUserRequest request) {
        return new CreateUserProfile(
                request.email()
                , request.password()
                , request.fullName()
                , request.nickname()
                , Gender.of(request.gender().name())
                , BirthDate.of(request.birthDate()));
    }

    public UserProfileResponse fromDomain(final UserProfile domain) {
        return UserProfileResponse.builder()
                                  .id(domain.uuid())
                                  .email(domain.email())
                                  .username(domain.fullName().fullName())
                                  .nickname(domain.nickname())
                                  .gender(GenderType.valueOf(domain.gender().code()))
                                  .birthDate(BirthDateResponse.of(domain.birthDate()))
                                  .build();
    }

}
