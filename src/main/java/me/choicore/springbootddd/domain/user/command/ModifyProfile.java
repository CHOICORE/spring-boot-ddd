package me.choicore.springbootddd.domain.user.command;

import lombok.Builder;

import static me.choicore.springbootddd.domain.user.command.UserCommand.Modify;

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
public record ModifyProfile(
        Long userId
        , String password
        , String nickname
) implements Modify<Long> {

    /**
     * default constructor
     *
     * @param userId   {@link Long}
     * @param password {@link String}
     * @param nickname {@link String}
     */
    @Builder
    public ModifyProfile {
        validate(nickname);
    }

    public void validate(final String nickname) {
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("userId must not be null");
        }
    }
}
