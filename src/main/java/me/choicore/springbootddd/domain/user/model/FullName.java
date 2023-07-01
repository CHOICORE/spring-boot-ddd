package me.choicore.springbootddd.domain.user.model;

/**
 * @param firstName {@link String}
 * @param lastName  {@link String}
 */
public record FullName(
        String firstName
        , String lastName
) {

    public FullName {
        validate(firstName, lastName);
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
