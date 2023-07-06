package me.choicore.springbootddd.domain.authentication.command;

import me.choicore.springbootddd.domain.authentication.model.Identifier;

public record AuthenticationCommand(

        Identifier identifier,
        String password
) {
    public AuthenticationCommand {
        validate(identifier, password);
    }


    private void validate(final Identifier identifier, final String password) {

    }


}
