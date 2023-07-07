package me.choicore.springbootddd.domain.authentication.command;

import me.choicore.springbootddd.application.rest.constant.IdentifierTypeHintDto;
import me.choicore.springbootddd.domain.authentication.model.Identifier;

public record LoginCommand(
        Identifier identifier,
        IdentifierTypeHintDto idTypeHint,
        String password
) {

}
