package me.choicore.springbootddd.domain.user.model;

import lombok.Builder;

/**
 * <p>
 * user profile creation model.
 * </p>
 *
 * @param username  {@link String}
 * @param nickname  {@link String}
 * @param birthDate {@link BirthDate}
 */
public record CreateUserProfile(
        String username
        , String nickname
        , BirthDate birthDate
) {

    /**
     * default constructor
     *
     * @param username  {@link String}
     * @param nickname  {@link String}
     * @param birthDate {@link BirthDate}
     */
    @Builder
    public CreateUserProfile {
        validate(username, nickname, birthDate);
    }

    private void validate(String username, String nickname, BirthDate birthDate) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("username must not be null or blank");
        }
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("nickname must not be null or blank");
        }
        if (birthDate == null) {
            throw new IllegalArgumentException("birthDate must not be null");
        }
    }
}
