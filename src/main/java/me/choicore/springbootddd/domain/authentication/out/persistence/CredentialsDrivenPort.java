package me.choicore.springbootddd.domain.authentication.out.persistence;


import me.choicore.springbootddd.domain.authentication.model.Token;

public interface CredentialsDrivenPort {


    Token login(String identifier, String password);

    void logout(String token);
}
