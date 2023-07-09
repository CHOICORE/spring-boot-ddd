package me.choicore.springbootddd.domain.authentication.in.usecase;

import me.choicore.springbootddd.domain.authentication.command.Identifier;
import me.choicore.springbootddd.domain.authentication.model.Token;

public interface AuthenticationUseCase {

    Token login(Identifier identifier, String password);

    void logout(String token);
}
