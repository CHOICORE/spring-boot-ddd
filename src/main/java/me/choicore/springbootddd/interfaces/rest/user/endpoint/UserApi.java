package me.choicore.springbootddd.interfaces.rest.user.endpoint;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.springbootddd.domain.user.in.usecase.ModifyUserProfileUseCase;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.interfaces.rest.user.dto.mapper.UserMapper;
import me.choicore.springbootddd.interfaces.rest.user.dto.request.CreateUserRequest;
import me.choicore.springbootddd.interfaces.rest.user.dto.response.UserProfileResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
class UserApi {

    private final ModifyUserProfileUseCase modifyUserProfileUseCase;
    private final UserMapper userMapper;

    @PostMapping("/users")
    public ResponseEntity<?> registerUser(CreateUserRequest request) {
        log.info("registerUser() is called with request: {}", request);

        UserProfile createdUser = modifyUserProfileUseCase.createBy(userMapper.toDomain(request));

        UserProfileResponse userProfileResponse = userMapper.fromDomain(createdUser);

        return ResponseEntity.ok(userProfileResponse);
    }
}
