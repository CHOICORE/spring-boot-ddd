package me.choicore.springbootddd.domain.user.model;


import java.util.Arrays;

/**
 * <p>
 * gender type code.
 * </p>
 */
public enum Gender {

    MALE("M"), FEMALE("F");

    final String code;

    Gender(String code) {
        this.code = code;
    }

    public static Gender of(final String code) {
        return Arrays.stream(values())
                     .filter(gender -> gender.code().equals(code))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Invalid Gender Code : " + code));
    }

    public String code() {
        return code;
    }
}
