package me.choicore.springbootddd.domain.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.authentication.out.persistence.CredentialsDrivenPort;


@RequiredArgsConstructor
public class AuthenticationService {

    private final CredentialsDrivenPort credentialsDrivenPort;

    public AuthToken login(final String identifier, final String password) {
        return credentialsDrivenPort.login(identifier, password);
    }
}
