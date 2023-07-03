package me.choicore.springbootddd.domain.user.model;

public record Credential(
        Long userId
        , String email
        , String nickname
        , String mobile
        , String password
) {

}
