package me.choicore.springbootddd.interfaces.rest.user.mappers;

import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;
import me.choicore.springbootddd.interfaces.rest.user.ports.in.CreateUserRequest;
import me.choicore.springbootddd.interfaces.rest.user.ports.out.UserProfileResponse;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public CreateUserProfile toDomain(CreateUserRequest request) {
        return new CreateUserProfile(request.getUsername(), request.getNickname());
    }

    public UserProfileResponse fromDomain(UserProfile domain) {
        return UserProfileResponse.builder()
                                  .id(domain.uuid())
                                  .username(domain.username())
                                  .nickname(domain.nickname())
                                  .build();
    }
}
