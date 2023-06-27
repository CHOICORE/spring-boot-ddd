package me.choicore.springbootddd.interfaces.rest.user.endpoints.v1;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.springbootddd.domain.model.CreateUser;
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
    public ResponseEntity<?> createUser(CreateUserRequest request) {
        // 유효성 검증 로직
        CreateUser register = createUserUseCase.register(userMapper.toDomain(request));
        UserProfileResponse userProfileResponse = userMapper.fromDomain(register);


        return ResponseEntity.ok(userProfileResponse);
    }
}
