package me.choicore.springbootddd.domain.authentication.model;


/**
 * <p>
 * user identifier model.
 * </p>
 *
 * @param email       {@link String}
 * @param phoneNumber {@link String}
 */
public record Identifier(
        String email
        , String phoneNumber
) {

//     정규식으로 검증할 때 사용
//     private final static Pattern EMAIL_REGEX = Pattern.compile("(.+)@.+");

    /**
     * default constructor
     *
     * @param email       {@link String}
     * @param phoneNumber {@link String}
     */
    public Identifier {
        validate(email, phoneNumber);
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
