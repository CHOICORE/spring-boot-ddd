package me.choicore.springbootddd.domain.user.model;

import lombok.Builder;

/**
 * <p>
 * user profile creation model.
 * </p>
 *
 * @param email     {@link String}
 * @param password  {@link String}
 * @param fullName  {@link FullName}
 * @param nickname  {@link String}
 * @param gender    {@link Gender}
 * @param birthDate {@link BirthDate}
 */
public record CreateUserProfile(
        String email
        , String password
        , FullName fullName
        , String nickname
        , Gender gender
        , BirthDate birthDate
) {

    /**
     * default constructor
     *
     * @param email     {@link String}
     * @param password  {@link String}
     * @param fullName  {@link FullName}
     * @param nickname  {@link String}
     * @param gender    {@link Gender}
     * @param birthDate {@link BirthDate}
     */
    @Builder
    public CreateUserProfile {
        validate(
                email
                , password
                , fullName
                , nickname
                , gender
                , birthDate

        );
    }

    private void validate(
            final String email
            , final String password
            , final FullName firstName
            , final String nickname
            , final Gender gender
            , final BirthDate birthDate
    ) {

    }
}
