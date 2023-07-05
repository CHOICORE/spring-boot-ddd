package me.choicore.springbootddd.domain.user.command;

import lombok.Builder;
import me.choicore.springbootddd.domain.user.command.UserCommand.Query;
import me.choicore.springbootddd.domain.user.model.Gender;
import me.choicore.springbootddd.domain.user.model.Username;

import java.util.UUID;

/**
 * <p>
 * user profile query model.
 * </p>
 *
 * @param uuid      {@link UUID}
 * @param userId    {@link Long}
 * @param username  {@link Username}
 * @param nickname  {@link String}
 * @param gender    {@link Gender}
 * @param birthYear {@link int}
 */
public record QueryProfile(
        UUID uuid
        , Long userId
        , Username username
        , String nickname
        , Gender gender

        , int birthYear
) implements Query<Long> {

    /**
     * default constructor
     *
     * @param uuid      {@link UUID}
     * @param userId    {@link Long}
     * @param username  {@link Username}
     * @param nickname  {@link String}
     * @param gender    {@link Gender}
     * @param birthYear {@link int}
     */
    @Builder
    public QueryProfile {
        validate(
                uuid
                , userId
                , username
                , nickname
                , gender
                , birthYear
        );
    }

    public void validate(final UUID uuid, final Long userId, final Username username, final String nickname, final Gender gender, final int birthYear) {
//        if (uuid == null) {
//            throw new IllegalArgumentException("uuid must not be null");
//        }
//        if (userId == null) {
//            throw new IllegalArgumentException("userId must not be null");
//        }
    }
}
