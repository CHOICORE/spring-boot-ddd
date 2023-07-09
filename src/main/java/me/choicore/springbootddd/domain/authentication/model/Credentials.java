package me.choicore.springbootddd.domain.authentication.model;

import me.choicore.springbootddd.domain.authentication.command.Identifier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * <p>
 * user credential model.
 * </p>
 *
 * @param userId                   {@link Long}
 * @param identifier               {@link Identifier}
 * @param token                    {@link Token}
 * @param loginAttempts            {@link Integer}
 * @param passwordUpdateRequiredAt {@link LocalDate}
 * @param lastLoggedInAt           {@link LocalDateTime}
 * @param roles                    {@link Set}
 */
public record Credentials(
        Long userId
        , Identifier identifier
        , Token token
        , int loginAttempts
        , LocalDate passwordUpdateRequiredAt
        , LocalDateTime lastLoggedInAt
        , Set<String> roles
) {

    /**
     * default constructor
     *
     * @param userId {@link Long}
     */
    public Credentials {
    }

    private void validate() {
    }

}
