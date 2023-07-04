package me.choicore.springbootddd.domain.authentication.model;

/**
 * <p>
 * user credential model.
 * </p>
 *
 * @param userId     {@link Long}
 * @param identifier {@link Identifier}
 * @param nickname   {@link String}
 */
public record Credential(
        Long userId
        , Identifier identifier
        , String nickname

) {

    /**
     * default constructor
     *
     * @param userId     {@link Long}
     * @param identifier {@link Identifier}
     * @param nickname   {@link String}
     */
    public Credential {
        validate(userId, identifier, nickname);
    }

    public void validate(final Long userId, final Identifier identifier, final String nickname) {
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }
        if (identifier == null) {
            throw new IllegalArgumentException("identifier must not be null");
        }
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("nickname must not be null");
        }
    }

}
