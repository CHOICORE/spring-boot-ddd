package me.choicore.springbootddd.domain.user.model;

import lombok.Builder;

/**
 * <p>
 * user profile modification model.
 * </p>
 *
 * @param userId   {@link Long}
 * @param nickname {@link String}
 */
@Builder
public record ModifyUserProfile(
        Long userId
        , String nickname
) {

    /**
     * default constructor
     *
     * @param userId   {@link Long}
     * @param nickname {@link String}
     */
    @Builder
    public ModifyUserProfile {
        validate(nickname);
    }

    private void validate(String nickname) {
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("userId must not be null");
        }
    }
}
