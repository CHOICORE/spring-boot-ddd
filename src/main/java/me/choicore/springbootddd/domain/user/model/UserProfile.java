package me.choicore.springbootddd.domain.user.model;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>
 * user profile retrieve model.
 * </p>
 */
public final class UserProfile {
    private final UUID uuid;
    private final Long userId;
    private final String username;
    private final String nickname;
    private final Gender gender;
    private final BirthDate birthDate;
    private final LocalDateTime createdAt;


    /**
     * default constructor
     *
     * @param uuid      {@link UUID}
     * @param userId    {@link Long}
     * @param username  {@link String}
     * @param nickname  {@link String}
     * @param gender    {@link Gender}
     * @param birthDate {@link BirthDate}
     */
    @Builder
    public UserProfile(
            final UUID uuid
            , final Long userId
            , final String username
            , final String nickname
            , final Gender gender
            , final BirthDate birthDate
            , final LocalDateTime createdAt) {
        this.validate(
                uuid
                , userId
                , username
                , nickname
                , gender
                , birthDate
        );
        this.uuid = uuid;
        this.userId = userId;
        this.username = username;
        this.nickname = nickname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
    }

    private void validate(UUID uuid, Long userId, String username, String nickname, Gender gender, BirthDate birthDate) {
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
        if (gender == null) {
            throw new IllegalArgumentException("gender must not be null");
        }
        if (birthDate == null) {
            throw new IllegalArgumentException("birthDate must not be null");
        }
    }

    public UUID uuid() {
        return uuid;
    }

    public Long userId() {
        return userId;
    }

    public String username() {
        return username;
    }

    public String nickname() {
        return nickname;
    }

    public Gender gender() {
        return gender;
    }

    public BirthDate birthDate() {
        return birthDate;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

}
