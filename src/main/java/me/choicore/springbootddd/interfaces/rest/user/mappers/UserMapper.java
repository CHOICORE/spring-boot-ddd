package me.choicore.springbootddd.interfaces.rest.user.mappers;

import me.choicore.springbootddd.domain.model.CreateUser;
import me.choicore.springbootddd.interfaces.rest.user.ports.in.CreateUserRequest;
import me.choicore.springbootddd.interfaces.rest.user.ports.out.UserProfileResponse;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public CreateUser toDomain(CreateUserRequest request) {
        return CreateUser.builder()
                         .username(request.getUsername())
                         .nickname(request.getNickname())
                         .build();
    }

    public UserProfileResponse fromDomain(CreateUser register) {
        return UserProfileResponse.builder()
                                  .username(register.getUsername())
                                  .nickname(register.getNickname())
                                  .build();
    }
}
