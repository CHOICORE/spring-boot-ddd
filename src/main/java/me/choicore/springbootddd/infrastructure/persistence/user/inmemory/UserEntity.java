package me.choicore.springbootddd.infrastructure.persistence.user.inmemory;

import lombok.Builder;

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
 * @param username   {@link String}
 * @param nickname   {@link String}
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
        , Gender gender
        , LocalDate birthDate
        , LocalDateTime createdAt
        , LocalDateTime modifiedAt) implements InMemoryEntity<Long> {


    /**
     * default constructor
     *
     * @param uuid       {@link UUID
     * @param userId     {@link Long}
     * @param email      {@link String}
     * @param password   {@link String}
     * @param firstName  {@link String}
     * @param lastName   {@link String}
     * @param username   {@link String}
     * @param nickname   {@link String}
     * @param gender     {@link Gender}
     * @param birthDate  {@link LocalDate}
     * @param createdAt  {@link LocalDateTime}
     * @param modifiedAt {@link LocalDateTime}
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
                         .email(this.email)
                         .password(this.password)
                         .firstName(this.firstName)
                         .lastName(this.lastName)
                         .nickname(nickname)
                         .userId(this.userId)
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
