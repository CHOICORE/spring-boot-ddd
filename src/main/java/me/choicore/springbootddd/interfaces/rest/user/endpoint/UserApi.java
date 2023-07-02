package me.choicore.springbootddd.interfaces.rest.user.endpoint;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.springbootddd.domain.user.in.usecase.ModifyUserProfileUseCase;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.interfaces.rest.ApiResponse;
import me.choicore.springbootddd.interfaces.rest.user.dto.mapper.PresentationUserMapper;
import me.choicore.springbootddd.interfaces.rest.user.dto.request.CreateUserRequest;
import me.choicore.springbootddd.interfaces.rest.user.dto.response.UserProfileResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
class UserApi {

    private final ModifyUserProfileUseCase modifyUserProfileUseCase;
    private final PresentationUserMapper presentationUserMapper;

    @PostMapping("/api/v1/users")
    public ResponseEntity<ApiResponse<UserProfileResponse>> registerUser(@RequestBody CreateUserRequest request) {
        log.info("registerUser() is called with request: {}", request);

        UserProfile createdUser = modifyUserProfileUseCase.createBy(presentationUserMapper.toDomain(request));

        UserProfileResponse userProfileResponse = presentationUserMapper.fromDomain(createdUser);

        ApiResponse<UserProfileResponse> succeed = ApiResponse.succeed(userProfileResponse);

        return ResponseEntity.ok(succeed);
    }
}
