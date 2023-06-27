package me.choicore.springbootddd.domain.model;

import lombok.Builder;

/**
 * user profile creation model.
 *
 * @param username {@link String}
 * @param nickname {@link String}
 */
@Builder
public record CreateUserProfile(
        String username,
        String nickname
) {

    /**
     * default constructor
     *
     * @param username {@link String}
     * @param nickname {@link String}
     */
    public CreateUserProfile {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("username must not be null or blank");
        }
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("nickname must not be null or blank");
        }
    }
}
