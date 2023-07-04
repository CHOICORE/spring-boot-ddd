package me.choicore.springbootddd.domain.authentication.command;

import me.choicore.springbootddd.domain.authentication.model.Identifier;

/**
 * <p>
 * user login command model.
 * </p>
 *
 * @param identifier {@link Identifier}
 * @param password   {@link String}
 */
public record LogInCommand(
        Identifier identifier
        , String password
) {

    /**
     * default constructor
     *
     * @param identifier {@link Identifier}
     * @param password   {@link String}
     */
    public LogInCommand {
        validate(identifier, password);
    }

    public void validate(final Identifier identifier, final String password) {
        if (identifier == null) {
            throw new IllegalArgumentException("identifier must not be null");
        } else {
            identifier.validate(identifier.email(), identifier.mobile());
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("password must not be null");
        }
    }
}
