package me.choicore.springbootddd.domain.authentication.in.usecase;

public interface AuthenticationUseCase {

    void authenticateBy(final String identifier, final String password);

}
