package me.choicore.springbootddd.domain.authentication.model;

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
 * @param loginAttempts            {@link Integer}
 * @param passwordUpdateRequiredAt {@link LocalDate}
 * @param lastLoggedInAt           {@link LocalDateTime}
 * @param isActive                 {@link Boolean}
 * @param roles                    {@link Set}
 */
public record Credentials(
        Long userId
        , Identifier identifier
        , int loginAttempts
        , LocalDate passwordUpdateRequiredAt
        , LocalDateTime lastLoggedInAt
        , boolean isActive // 계정 활성화 여부 - 계정 활성화 상태를 위한 필드를 하나 만들 것인지, 검증을 하는 메서드로 처리할 것인지
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
