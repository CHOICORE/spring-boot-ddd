package me.choicore.springbootddd.domain.model;

import lombok.Builder;

import java.util.UUID;

/**
 * user profile modification model.
 *
 * @param uuid     {@link UUID}
 * @param userId   {@link Long}
 * @param username {@link String}
 * @param nickname {@link String}
 */
@Builder
public record ModifyUserProfile(
        UUID uuid
        , Long userId
        , String username
        , String nickname
) {

    /**
     * default constructor
     *
     * @param uuid     {@link UUID}
     * @param userId   {@link Long}
     * @param username {@link String}
     * @param nickname {@link String}
     */
    @Builder
    public ModifyUserProfile {
        validate();
    }

    private void validate() {
        if (uuid == null) {
            throw new IllegalArgumentException("uuid must not be null");
        }
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }

    }
}
