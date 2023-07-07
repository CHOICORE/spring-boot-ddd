package me.choicore.springbootddd.domain.authentication.out.persistence;

import me.choicore.springbootddd.domain.service.AuthToken;

public interface CredentialsDrivenPort {


    AuthToken login(String identifier, String password);
}
