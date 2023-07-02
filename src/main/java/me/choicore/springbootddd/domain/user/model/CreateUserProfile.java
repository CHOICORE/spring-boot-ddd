package me.choicore.springbootddd.domain.user.model;

import lombok.Builder;

/**
 * <p>
 * user profile creation model.
 * </p>
 *
 * @param email     {@link String}
 * @param password  {@link String}
 * @param username  {@link Username}
 * @param nickname  {@link String}
 * @param gender    {@link Gender}
 * @param birthDate {@link BirthDate}
 */
public record CreateUserProfile(
        String email
        , String password
        , Username username
        , String nickname
        , Gender gender
        , BirthDate birthDate
) {

    /**
     * default constructor
     *
     * @param email     {@link String}
     * @param password  {@link String}
     * @param username  {@link Username}
     * @param nickname  {@link String}
     * @param gender    {@link Gender}
     * @param birthDate {@link BirthDate}
     */
    @Builder
    public CreateUserProfile {
        validate(
                email
                , password
                , username
                , nickname
                , gender
                , birthDate

        );
    }

    /**
     * validate for parameters
     *
     * @param email     {@link String}
     * @param password  {@link String}
     * @param username  {@link Username}
     * @param nickname  {@link String}
     * @param gender    {@link Gender}
     * @param birthDate {@link BirthDate}
     */
    private void validate(
            final String email
            , final String password
            , final Username username
            , final String nickname
            , final Gender gender
            , final BirthDate birthDate
    ) {


        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email is null or blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("password is null or blank");
        }

        if (username == null) {
            throw new IllegalArgumentException("username is null");
        }
        // validate username
        if (username.firstName() == null || username.firstName().isBlank()) {
            throw new IllegalArgumentException("username.firstName is null or blank");
        }
        if (username.lastName() == null || username.lastName().isBlank()) {
            throw new IllegalArgumentException("username.lastName is null or blank");
        }

        // validate nickname
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("nickname is null or blank");
        }
    }

}
