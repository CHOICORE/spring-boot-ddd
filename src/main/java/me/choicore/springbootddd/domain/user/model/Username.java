package me.choicore.springbootddd.domain.user.model;

import lombok.Builder;

/**
 * @param firstName {@link String}
 * @param lastName  {@link String}
 */
public record Username(
        String firstName
        , String lastName
) {
    @Builder
    public Username {
        validate(firstName, lastName);
    }

    public static Username of(final String firstName, final String lastName) {
        return Username.builder()
                       .firstName(firstName)
                       .lastName(lastName)
                       .build();
    }

    public void validate(final String firstName, final String lastName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("firstName must not be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("lastName must not be null or blank");
        }
    }

    /**
     * @return {@link String}
     */
    public String fullName() {
        return this.firstName + " " + this.lastName;
    }
}
