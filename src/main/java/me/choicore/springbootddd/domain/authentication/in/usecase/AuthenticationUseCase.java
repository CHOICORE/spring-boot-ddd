package me.choicore.springbootddd.domain.authentication.in.usecase;

import me.choicore.springbootddd.domain.authentication.command.LoginCommand;
import me.choicore.springbootddd.domain.service.AuthToken;

public interface AuthenticationUseCase {

    AuthToken login(LoginCommand loginCommand);

    void logout(String token);
}
