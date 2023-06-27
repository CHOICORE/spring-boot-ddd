package me.choicore.springbootddd.interfaces.rest.user.dtos.mappers;

import me.choicore.springbootddd.domain.model.BirthDate;
import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;
import me.choicore.springbootddd.interfaces.rest.user.dtos.request.CreateUserRequest;
import me.choicore.springbootddd.interfaces.rest.user.dtos.response.UserProfileResponse;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public CreateUserProfile toDomain(CreateUserRequest request) {
        return new CreateUserProfile(request.username()
                , request.nickname()
                , BirthDate.of(request.birthDate()));
    }

    public UserProfileResponse fromDomain(UserProfile domain) {
        return UserProfileResponse.builder()
                                  .id(domain.uuid())
                                  .username(domain.username())
                                  .nickname(domain.nickname())
                                  .build();
    }
}
