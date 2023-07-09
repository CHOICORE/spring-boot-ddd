package me.choicore.springbootddd.presentation.rest.adapter.user.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.springbootddd.domain.authentication.in.usecase.AuthorizationUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthUseCaseAdapter {

    private final AuthorizationUseCase authorizationUseCase;

}
