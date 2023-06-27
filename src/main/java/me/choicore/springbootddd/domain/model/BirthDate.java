package me.choicore.springbootddd.domain.model;

import lombok.Builder;

import java.time.LocalDate;

/**
 * <p>user profile attributes</p>
 * <p>
 * birth-date model.
 *
 * @param year       {@link int}
 * @param month      {@link int}
 * @param dayOfMonth {@link int}
 */
public record BirthDate(
        int year
        , int month
        , int dayOfMonth
) {
    private static LocalDate DAY_OF_BIRTH;

    /**
     * default constructor
     *
     * @param year       {@link int}
     * @param month      {@link int}
     * @param dayOfMonth {@link int}
     */
    @Builder
    public BirthDate {
        validate(year, month, dayOfMonth);
    }

    /**
     * @param birthDate {@link LocalDate}
     * @return {@link BirthDate}
     */

    public static BirthDate of(LocalDate birthDate) {
        return BirthDate.of(
                birthDate.getYear()
                , birthDate.getMonthValue()
                , birthDate.getDayOfMonth()
        );
    }

    /**
     * @param year       {@link int}
     * @param month      {@link int}
     * @param dayOfMonth {@link int}
     * @return {@link BirthDate}
     */
    public static BirthDate of(int year, int month, int dayOfMonth) {
        return new BirthDate(year, month, dayOfMonth);
    }

    /**
     * @return {@link LocalDate}
     */
    public LocalDate dayOfBirth() {
        return DAY_OF_BIRTH;
    }

    private void validate(int year, int month, int dayOfMonth) {
        try {
            DAY_OF_BIRTH = LocalDate.of(year, month, dayOfMonth);
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid date");
        }
    }
}
