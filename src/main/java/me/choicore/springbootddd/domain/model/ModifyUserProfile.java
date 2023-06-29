package me.choicore.springbootddd.domain.model;

import lombok.Builder;

/**
 * user profile modification model.
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
        validate();
    }

    private void validate() {
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }
    }
}
