package me.choicore.springbootddd.domain.authentication.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * <p>
 * user credential model.
 * </p>
 *
 * @param userId     {@link Long}
 * @param identifier {@link Identifier}
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
     * @param userId     {@link Long}
     * @param identifier {@link Identifier}
     */
    public Credentials {
        validate(userId, identifier);
    }

    private void validate(final Long userId, final Identifier identifier) {
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }
        if (identifier == null) {
            throw new IllegalArgumentException("identifier must not be null");
        }

    }

}
