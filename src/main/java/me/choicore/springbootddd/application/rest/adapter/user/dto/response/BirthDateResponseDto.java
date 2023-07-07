package me.choicore.springbootddd.application.rest.adapter.user.dto.response;

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
public record BirthDateResponseDto(
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
    public BirthDateResponseDto {
        validate(year, month, dayOfMonth);
    }

    /**
     * @param birthDate {@link LocalDate}
     * @return {@link BirthDateResponseDto}
     */
    public static BirthDateResponseDto of(LocalDate birthDate) {
        return of(
                birthDate.getYear()
                , birthDate.getMonthValue()
                , birthDate.getDayOfMonth()
        );
    }

    /**
     * @param birthDate {@link String}
     * @return {@link BirthDateResponseDto}
     */
    public static BirthDateResponseDto of(BirthDate birthDate) {
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
     * @return {@link BirthDateResponseDto}
     */
    public static BirthDateResponseDto of(int year, int month, int dayOfMonth) {
        return new BirthDateResponseDto(year, month, dayOfMonth);
    }


    /**
     * @return {@link LocalDate}
     */
    public LocalDate dateOfBirth() {
        return DATE_OF_BIRTH;
    }

    private void validate(int year, int month, int dayOfMonth) {
        try {
            DATE_OF_BIRTH = LocalDate.of(year, month, dayOfMonth);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

}
