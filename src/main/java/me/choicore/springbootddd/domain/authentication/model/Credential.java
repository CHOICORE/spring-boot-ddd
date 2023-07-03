package me.choicore.springbootddd.domain.authentication.model;

public record Credential(
        Long userId
        , Identifier identifier
        , String nickname

) {

}
