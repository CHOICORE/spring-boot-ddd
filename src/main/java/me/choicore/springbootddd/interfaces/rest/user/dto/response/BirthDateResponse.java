package me.choicore.springbootddd.interfaces.rest.user.dto.response;

import lombok.Builder;
import me.choicore.springbootddd.domain.user.model.BirthDate;

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
public record BirthDateResponse(
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
    public BirthDateResponse {
        validate(year, month, dayOfMonth);
    }

    /**
     * @param birthDate {@link LocalDate}
     * @return {@link BirthDateResponse}
     */
    public static BirthDateResponse of(LocalDate birthDate) {
        return of(
                birthDate.getYear()
                , birthDate.getMonthValue()
                , birthDate.getDayOfMonth()
        );
    }

    /**
     * @param birthDate {@link String}
     * @return {@link BirthDateResponse}
     */
    public static BirthDateResponse of(BirthDate birthDate) {
        return of(
                birthDate.year()
                , birthDate.month()
                , birthDate.dayOfMonth()
        );
    }

    /**
     * @param year       {@link int}
     * @param month      {@link int}
     * @param dayOfMonth {@link int}
     * @return {@link BirthDateResponse}
     */
    public static BirthDateResponse of(int year, int month, int dayOfMonth) {
        return new BirthDateResponse(year, month, dayOfMonth);
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
