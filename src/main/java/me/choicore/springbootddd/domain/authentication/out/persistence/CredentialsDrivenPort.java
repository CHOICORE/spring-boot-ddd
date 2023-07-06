package me.choicore.springbootddd.domain.authentication.out.persistence;

import me.choicore.springbootddd.domain.authentication.model.Credentials;

public interface CredentialsDrivenPort {


    Credentials login(String identifier, String password);
}
