package me.choicore.springbootddd.domain.authentication.command;

import me.choicore.springbootddd.domain.authentication.model.Identifier;

public record LogInCommand(

        Identifier identifier
        , String password
) {
}
