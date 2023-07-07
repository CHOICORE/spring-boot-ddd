package me.choicore.springbootddd.application.rest.adapter.user.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.springbootddd.domain.authentication.in.usecase.AuthenticationUseCase;
import me.choicore.springbootddd.domain.authentication.in.usecase.AuthorizationUseCase;
import me.choicore.springbootddd.domain.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthUseCaseAdapter implements
        AuthenticationUseCase,
        AuthorizationUseCase {

    private final AuthenticationService authenticationService;

    @Override
    public void authenticateBy(final String identifier, final String password) {

    }

}
