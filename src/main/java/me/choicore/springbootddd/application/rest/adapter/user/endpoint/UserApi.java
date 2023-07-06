package me.choicore.springbootddd.application.rest.adapter.user.endpoint;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.springbootddd.application.rest.ApiResponse;
import me.choicore.springbootddd.application.rest.adapter.user.dto.mapper.PresentationUserMapper;
import me.choicore.springbootddd.application.rest.adapter.user.dto.request.CreateUserRequest;
import me.choicore.springbootddd.application.rest.adapter.user.dto.response.UserProfileResponse;
import me.choicore.springbootddd.domain.user.in.usecase.GetUserProfileQuery;
import me.choicore.springbootddd.domain.user.in.usecase.ModifyUserProfileUseCase;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequiredArgsConstructor
class UserApi {

    private final ModifyUserProfileUseCase modifyUserProfileUseCase;
    private final GetUserProfileQuery getUserProfileQuery;
    private final PresentationUserMapper presentationUserMapper;

    @PostMapping("/api/v1/users")
    public ResponseEntity<ApiResponse<UserProfileResponse>> registerUser(@RequestBody CreateUserRequest request) {
        log.info("registerUser() is called with request: {}", request);

        UserProfile createdUser = modifyUserProfileUseCase.createBy(presentationUserMapper.toDomain(request));

        UserProfileResponse userProfileResponse = presentationUserMapper.fromDomain(createdUser);

        ApiResponse<UserProfileResponse> succeed = ApiResponse.succeed(userProfileResponse);

        return ResponseEntity.ok(succeed);
    }

    @GetMapping("/api/v1/users/{userId}")
    public ResponseEntity<ApiResponse<UserProfileResponse>> getUserProfile(@PathVariable("userId") Long userId) {
        log.info("getUserProfile() is called with userId: {}", userId);

        UserProfile foundUserProfile = getUserProfileQuery.getUserProfile(userId);

        UserProfileResponse userProfileResponse = presentationUserMapper.fromDomain(foundUserProfile);

        ApiResponse<UserProfileResponse> succeed = ApiResponse.succeed(userProfileResponse);

        return ResponseEntity.ok(succeed);
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ApiResponse<List<UserProfileResponse>>> getUserProfiles() {
        log.info("getUserProfiles() is called");

        List<UserProfile> foundUserProfiles = getUserProfileQuery.getAllUserProfiles();

        List<UserProfileResponse> collect = foundUserProfiles.stream().flatMap(userProfile -> {
            UserProfileResponse userProfileResponse = presentationUserMapper.fromDomain(userProfile);
            return Stream.of(userProfileResponse);
        }).collect(Collectors.toList());

        ApiResponse<List<UserProfileResponse>> succeed = ApiResponse.succeed(collect);

        return ResponseEntity.ok(succeed);
    }

}
