package me.choicore.springbootddd.domain.model;

import lombok.Builder;

import java.util.UUID;

/**
 * user profile retrieve model.
 *
 * @param uuid     {@link UUID}
 * @param userId   {@link Long}
 * @param username {@link String}
 * @param nickname {@link String}
 */
@Builder
public record UserProfile(
        UUID uuid,
        Long userId,
        String username,
        String nickname
) {

    /**
     * default constructor
     *
     * @param uuid     {@link UUID}
     * @param userId   {@link Long}
     * @param username {@link String}
     * @param nickname {@link String}
     */
    public UserProfile {
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
