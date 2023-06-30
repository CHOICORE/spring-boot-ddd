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
public class ClientUserMapper {

    public CreateUserProfile toDomain(CreateUserRequest request) {
        return new CreateUserProfile(request.username()
                , request.nickname()
                , Gender.of(request.gender().name())
                , BirthDate.of(request.birthDate()));
    }

    public UserProfileResponse fromDomain(UserProfile domain) {
        return UserProfileResponse.builder()
                                  .id(domain.uuid())
                                  .username(domain.username())
                                  .nickname(domain.nickname())
                                  .gender(GenderType.valueOf(domain.gender().code()))
                                  .birthDate(BirthDateResponse.of(domain.birthDate()))
                                  .build();
    }

}
