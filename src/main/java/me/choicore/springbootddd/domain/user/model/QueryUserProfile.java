package me.choicore.springbootddd.domain.user.model;

import lombok.Builder;

import java.util.UUID;

/**
 * <p>
 * user profile query model.
 * </p>
 *
 * @param uuid      {@link UUID}
 * @param userId    {@link Long}
 * @param username  {@link String}
 * @param nickname  {@link String}
 * @param birthYear {@link int}
 */
public record QueryUserProfile(
        UUID uuid
        , Long userId
        , String username
        , String nickname
        , int birthYear
) {

    /**
     * default constructor
     *
     * @param uuid      {@link UUID}
     * @param userId    {@link Long}
     * @param username  {@link String}
     * @param nickname  {@link String}
     * @param birthYear {@link int}
     */
    @Builder
    public QueryUserProfile {
        validate(
                uuid
                , userId
                , username
                , nickname
                , birthYear
        );
    }

    private void validate(UUID uuid, Long userId, String username, String nickname, int birthYear) {
//        if (uuid == null) {
//            throw new IllegalArgumentException("uuid must not be null");
//        }
//        if (userId == null) {
//            throw new IllegalArgumentException("userId must not be null");
//        }
    }
}
