package me.choicore.springbootddd.domain.user.model;

import lombok.Builder;

/**
 * @param firstName {@link String}
 * @param lastName  {@link String}
 */
public record FullName(
        String firstName
        , String lastName
) {
    @Builder
    public FullName {
        validate(firstName, lastName);
    }

    public static FullName of(final String firstName, final String lastName) {
        return FullName.builder()
                       .firstName(firstName)
                       .lastName(lastName)
                       .build();
    }

    private void validate(final String firstName, final String lastName) {
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
