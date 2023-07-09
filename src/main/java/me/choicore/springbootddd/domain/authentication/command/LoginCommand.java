package me.choicore.springbootddd.domain.authentication.command;

import lombok.Builder;

public record LoginCommand(
        Identifier identifier,
        String password
) {


    @Builder
    public LoginCommand(final Identifier identifier, final String password) {
        this.identifier = identifier;
        this.password = password;
    }
}
