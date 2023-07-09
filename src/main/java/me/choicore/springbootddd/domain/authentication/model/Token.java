package me.choicore.springbootddd.domain.authentication.model;

public record Token(
        String accessToken,
        String refreshToken,
        TokenType tokenType,
        int expiresIn

) {
}
