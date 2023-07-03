package me.choicore.springbootddd.domain.user.command;

import lombok.Builder;

/**
 * <p>
 * user profile modification model.
 * </p>
 *
 * @param userId   {@link Long}
 * @param password {@link String}
 * @param nickname {@link String}
 */
@Builder
public record ModifyUserProfile(
        Long userId
        , String password
        , String nickname
) {

    /**
     * default constructor
     *
     * @param userId   {@link Long}
     * @param password {@link String}
     * @param nickname {@link String}
     */
    @Builder
    public ModifyUserProfile {
        validate(nickname);
    }

    private void validate(final String nickname) {
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("userId must not be null");
        }
    }
}
