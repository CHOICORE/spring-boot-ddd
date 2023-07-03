package me.choicore.springbootddd.domain.authentication.command;

import me.choicore.springbootddd.domain.authentication.model.CredentialId;

public record LogInCommand(

        CredentialId credentialId
        , String password
) {
}
