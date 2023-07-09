package me.choicore.springbootddd.domain.authentication.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.authentication.command.Identifier;
import me.choicore.springbootddd.domain.authentication.in.usecase.AuthenticationUseCase;
import me.choicore.springbootddd.domain.authentication.model.Token;
import me.choicore.springbootddd.domain.authentication.out.persistence.CredentialsDrivenPort;


@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationUseCase {

    private final CredentialsDrivenPort credentialsDrivenPort;

    @Override
    public Token login(final Identifier identifier, final String password) {
        return credentialsDrivenPort.login(identifier.getIdentifierByTypeHint(), password);
    }

    @Override
    public void logout(final String token) {
        credentialsDrivenPort.logout(token);
    }
}
