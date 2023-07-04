package me.choicore.springbootddd.domain.user.model;

import lombok.Builder;

import java.time.LocalDate;

/**
 * <p>
 * user profile attributes.
 * birth-date model.
 * </p>
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
    private static LocalDate DATE_OF_BIRTH;

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
    public static BirthDate of(final LocalDate birthDate) {
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
    public static BirthDate of(final int year, final int month, final int dayOfMonth) {
        return new BirthDate(year, month, dayOfMonth);
    }

    /**
     * @return {@link LocalDate}
     */
    public LocalDate dateOfBirth() {
        return DATE_OF_BIRTH;
    }

    public void validate(final int year, final int month, final int dayOfMonth) {
        try {
            DATE_OF_BIRTH = LocalDate.of(year, month, dayOfMonth);
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid date");
        }
    }
}
