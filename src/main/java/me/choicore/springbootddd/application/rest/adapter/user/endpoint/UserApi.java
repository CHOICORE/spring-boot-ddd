package me.choicore.springbootddd.application.rest.adapter.user.endpoint;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.springbootddd.application.rest.ApiResponse;
import me.choicore.springbootddd.application.rest.adapter.user.dto.mapper.UserDtoMapper;
import me.choicore.springbootddd.application.rest.adapter.user.dto.request.CreateUserRequestDto;
import me.choicore.springbootddd.application.rest.adapter.user.dto.response.UserProfileResponseDto;
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
    private final UserDtoMapper userDtoMapper;

    @PostMapping("/api/v1/users")
    public ResponseEntity<ApiResponse<UserProfileResponseDto>> registerUser(@RequestBody CreateUserRequestDto request) {
        log.info("registerUser() is called with request: {}", request);

        UserProfile createdUser = modifyUserProfileUseCase.createBy(userDtoMapper.toDomain(request));

        UserProfileResponseDto userProfileResponseDto = userDtoMapper.fromDomain(createdUser);

        ApiResponse<UserProfileResponseDto> succeed = ApiResponse.succeed(userProfileResponseDto);

        return ResponseEntity.ok(succeed);
    }

    @GetMapping("/api/v1/users/{userId}")
    public ResponseEntity<ApiResponse<UserProfileResponseDto>> getUserProfile(@PathVariable("userId") Long userId) {
        log.info("getUserProfile() is called with userId: {}", userId);

        UserProfile foundUserProfile = getUserProfileQuery.getUserProfile(userId);

        UserProfileResponseDto userProfileResponseDto = userDtoMapper.fromDomain(foundUserProfile);

        ApiResponse<UserProfileResponseDto> succeed = ApiResponse.succeed(userProfileResponseDto);

        return ResponseEntity.ok(succeed);
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ApiResponse<List<UserProfileResponseDto>>> getUserProfiles() {
        log.info("getUserProfiles() is called");

        List<UserProfile> foundUserProfiles = getUserProfileQuery.getAllUserProfiles();

        List<UserProfileResponseDto> collect = foundUserProfiles.stream().flatMap(userProfile -> {
            UserProfileResponseDto userProfileResponseDto = userDtoMapper.fromDomain(userProfile);
            return Stream.of(userProfileResponseDto);
        }).collect(Collectors.toList());

        ApiResponse<List<UserProfileResponseDto>> succeed = ApiResponse.succeed(collect);

        return ResponseEntity.ok(succeed);
    }

}
