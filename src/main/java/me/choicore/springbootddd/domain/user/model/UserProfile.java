package me.choicore.springbootddd.domain.user.model;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>
 * user profile retrieve model.
 * </p>
 *
 * @param uuid      {@link UUID}
 * @param userId    {@link Long}
 * @param email     {@link String}
 * @param password  {@link String}
 * @param username  {@link Username}
 * @param nickname  {@link String}
 * @param gender    {@link Gender}
 * @param birthDate {@link BirthDate}
 * @param createdAt {@link LocalDateTime}
 */
public record UserProfile(
        UUID uuid
        , Long userId
        , String email
        , String password
        , Username username
        , String nickname
        , Gender gender
        , BirthDate birthDate
        , LocalDateTime createdAt) {
    /**
     * default constructor
     *
     * @param uuid      {@link UUID}
     * @param userId    {@link Long}
     * @param email     {@link String}
     * @param password  {@link String}
     * @param username  {@link Username}
     * @param nickname  {@link String}
     * @param gender    {@link Gender}
     * @param birthDate {@link BirthDate}
     * @param createdAt {@link LocalDateTime}
     */
    @Builder
    public UserProfile {
        this.validate(
                uuid
                , userId
                , email
                , password
                , username
                , nickname
                , gender
                , birthDate
        );
    }

    private void validate(final UUID uuid, final Long userId, final String email, final String password, final Username username, final String nickname, final Gender gender, final BirthDate birthDate) {
        if (uuid == null) {
            throw new IllegalArgumentException("uuid must not be null");
        }
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email must not be null or blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("password must not be null or blank");
        }
        if (username == null) {
            throw new IllegalArgumentException("fullName must not be null");
        }
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("nickname must not be null or blank");
        }
        if (gender == null) {
            throw new IllegalArgumentException("gender must not be null");
        }
        if (birthDate == null) {
            throw new IllegalArgumentException("birthDate must not be null");
        }
    }

}
