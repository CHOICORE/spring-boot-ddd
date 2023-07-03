package me.choicore.springbootddd.domain.authentication.model;

public record Credential(
        Long userId
        , CredentialId credentialId
        , String nickname

) {

}
