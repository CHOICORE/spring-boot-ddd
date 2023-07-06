package me.choicore.springbootddd.domain.authentication.in.usecase;

import me.choicore.springbootddd.domain.authentication.command.AuthenticationCommand;
import me.choicore.springbootddd.domain.authentication.model.Credentials;

public interface AuthenticationUseCase {

    Credentials authenticateBy(final AuthenticationCommand authenticationCommand);

    Credentials authenticateBy(String identifier, String password);

}
