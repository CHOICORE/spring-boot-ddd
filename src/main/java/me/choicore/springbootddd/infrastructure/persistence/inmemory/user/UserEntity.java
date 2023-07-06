package me.choicore.springbootddd.infrastructure.persistence.inmemory.user;

import lombok.Builder;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.InMemoryEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * User entity for in-memory database.
 *
 * @param uuid       {@link UUID
 * @param userId     {@link Long}
 * @param email      {@link String}
 * @param password   {@link String}
 * @param firstName  {@link String}
 * @param lastName   {@link String}
 * @param nickname   {@link String}
 * @param phoneNumber     {@link String}
 * @param gender     {@link Gender}
 * @param birthDate  {@link LocalDate}
 * @param createdAt  {@link LocalDateTime}
 * @param modifiedAt {@link LocalDateTime}
 */
public record UserEntity(
        UUID uuid
        , Long userId
        , String email
        , String password
        , String firstName
        , String lastName
        , String nickname
        , String mobile
        , Gender gender
        , LocalDate birthDate
        , int loginAttempts
        , LocalDateTime lastLoggedInAt
        , LocalDateTime createdAt
        , LocalDateTime modifiedAt

) implements InMemoryEntity<Long> {


    /**
     * default constructor
     */
    @Builder
    public UserEntity {
    }

    public static UserEntityBuilder withGenerateUuid() {
        return UserEntity.builder()
                         .uuid(UUID.randomUUID())
                         .createdAt(LocalDateTime.now())
                         .modifiedAt(null);
    }

    @Override
    public Long id() {
        return this.userId;
    }

    public UserEntity changeNickname(final String nickname) {
        return UserEntity.builder()
                         .uuid(this.uuid)
                         .userId(this.userId)
                         .email(this.email)
                         .password(this.password)
                         .firstName(this.firstName)
                         .lastName(this.lastName)
                         .nickname(nickname)
                         .mobile(this.mobile)
                         .gender(this.gender)
                         .birthDate(this.birthDate)
                         .createdAt(this.createdAt)
                         .modifiedAt(LocalDateTime.now()).build();
    }

    public String fullName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * gender code.
     */
    public enum Gender {
        M, F
    }

}
