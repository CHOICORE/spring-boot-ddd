package me.choicore.springbootddd.interfaces.rest.user.endpoints.v1;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.springbootddd.domain.model.UserProfile;
import me.choicore.springbootddd.domain.ports.in.usecase.CreateUserUseCase;
import me.choicore.springbootddd.interfaces.rest.user.mappers.UserMapper;
import me.choicore.springbootddd.interfaces.rest.user.ports.in.CreateUserRequest;
import me.choicore.springbootddd.interfaces.rest.user.ports.out.UserProfileResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
class UserApi {

    private final CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper;

    @PostMapping("/users")
    public ResponseEntity<?> registerUser(CreateUserRequest request) {
        log.info("registerUser() is called with request: {}", request);

        UserProfile createdUser = createUserUseCase.createBy(userMapper.toDomain(request));

        UserProfileResponse userProfileResponse = userMapper.fromDomain(createdUser);

        return ResponseEntity.ok(userProfileResponse);
    }
}
