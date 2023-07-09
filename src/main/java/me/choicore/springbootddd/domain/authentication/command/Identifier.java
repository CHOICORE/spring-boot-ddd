package me.choicore.springbootddd.domain.authentication.command;


import lombok.Builder;

/**
 * <p>
 * user identifier command
 * </p>
 *
 * @param email              {@link String}
 * @param phoneNumber        {@link String}
 * @param identifierTypeHint {@link IdentifierTypeHint}
 */
public record Identifier(
        String email
        , String phoneNumber
        , IdentifierTypeHint identifierTypeHint
) {

//     정규식으로 검증할 때 사용
//     private final static Pattern EMAIL_REGEX = Pattern.compile("(.+)@.+");

    /**
     * default constructor
     *
     * @param email              {@link String}
     * @param phoneNumber        {@link String}
     * @param identifierTypeHint {@link IdentifierTypeHint}
     */
    @Builder
    public Identifier(final String email, final String phoneNumber, final IdentifierTypeHint identifierTypeHint) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.identifierTypeHint = identifierTypeHint;
    }


    public String getIdentifierByTypeHint() {
        return switch (this.identifierTypeHint) {
            case EMAIL -> this.email;
            case PHONE_NUMBER -> this.phoneNumber;
        };
    }


    /**
     * @return {@link String}
     */
    public String extractLocalPartFromEmailAddress() {
        if (!this.email.contains("@")) return this.email;
        return this.email.substring(0, this.email.indexOf("@"));
    }

    private void validate(final String email, final String mobile) {

    }
}
