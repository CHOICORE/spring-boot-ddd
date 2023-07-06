package me.choicore.springbootddd.domain.authentication.model;


/**
 * <p>
 * user identifier model.
 * </p>
 *
 * @param email       {@link String}
 * @param phoneNumber {@link String}
 * @param password    {@link String}
 */
public record Identifier(
        String email
        , String phoneNumber
        , String password
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
        validate(email, phoneNumber, password);
    }


    /**
     * @return {@link String}
     */
    public String identifier() {
        if (!this.email.contains("@")) return this.email;
        return this.email.substring(0, this.email.indexOf("@"));
    }


    private void validate(final String email, final String mobile, final String password) {
        if (email == null && mobile == null) {
            throw new IllegalArgumentException("email or phoneNumber must not be null");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("password must not be null");
        }
    }
}
