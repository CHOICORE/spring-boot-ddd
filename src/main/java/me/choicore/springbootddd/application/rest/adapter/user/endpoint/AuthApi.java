package me.choicore.springbootddd.application.rest.adapter.user.endpoint;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.springbootddd.application.rest.ApiResponse;
import me.choicore.springbootddd.application.rest.adapter.user.dto.request.AuthenticationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthApi {


    public ResponseEntity<ApiResponse<?>> login(@RequestBody AuthenticationRequestDto authenticationRequestDto) {

        return null;
    }
}
