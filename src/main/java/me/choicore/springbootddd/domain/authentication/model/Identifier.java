package me.choicore.springbootddd.domain.authentication.model;


/**
 * <p>
 * user identifier model.
 * </p>
 *
 * @param email  {@link String}
 * @param mobile {@link String}
 */
public record Identifier(
        String email
        , String mobile
) {

    /**
     * default constructor
     *
     * @param email  {@link String}
     * @param mobile {@link String}
     */
    public Identifier {
        validate(email, mobile);
    }

    public void validate(final String email, final String mobile) {
        if (email == null && mobile == null) {
            throw new IllegalArgumentException("email or mobile must not be null");
        }
        if (email != null && mobile != null) {
            throw new IllegalArgumentException("email and mobile must not be both not null");
        }
    }
}
