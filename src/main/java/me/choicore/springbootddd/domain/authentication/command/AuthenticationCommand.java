package me.choicore.springbootddd.domain.authentication.command;

public record AuthenticationCommand(
        String email,
        String phoneNumber,
        String password
) {
    public AuthenticationCommand {
        validate(email, phoneNumber, password);
    }

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
