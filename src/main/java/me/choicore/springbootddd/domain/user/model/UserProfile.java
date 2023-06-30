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
 * @param username  {@link String}
 * @param nickname  {@link String}
 * @param birthDate {@link BirthDate}
 * @param createdAt {@link LocalDateTime}
 */
public record UserProfile(
        UUID uuid
        , Long userId
        , String username
        , String nickname
        , BirthDate birthDate
        , LocalDateTime createdAt

) {

    /**
     * default constructor
     *
     * @param uuid      {@link UUID}
     * @param userId    {@link Long}
     * @param username  {@link String}
     * @param nickname  {@link String}
     * @param birthDate {@link BirthDate}
     */
    @Builder
    public UserProfile {
        validate(
                uuid
                , userId
                , username
                , nickname
                , birthDate
        );
    }

    private void validate(UUID uuid, Long userId, String username, String nickname, BirthDate birthDate) {
        if (uuid == null) {
            throw new IllegalArgumentException("uuid must not be null");
        }
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("username must not be null or blank");
        }
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("nickname must not be null or blank");
        }
    }
}
