package me.choicore.springbootddd.domain.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.authentication.command.AuthenticationCommand;
import me.choicore.springbootddd.domain.authentication.model.Credentials;
import me.choicore.springbootddd.domain.authentication.out.persistence.CredentialsDrivenPort;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserDrivenPort;


@RequiredArgsConstructor
public class AuthenticationService {

    private final CredentialsDrivenPort credentialsDrivenPort;

    private final QueryUserDrivenPort queryUserDrivenPort;

    public Credentials authenticate(final AuthenticationCommand authenticationCommand) {

        // inport 가공해서 -> outport에 전달

        return credentialsDrivenPort.login(authenticationCommand.identifier(), authenticationCommand.password());

    }

}
