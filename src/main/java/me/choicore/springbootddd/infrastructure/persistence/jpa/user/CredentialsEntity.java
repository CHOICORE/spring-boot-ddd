package me.choicore.springbootddd.infrastructure.persistence.jpa.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;


@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Embeddable
public class CredentialsEntity {

    @Embedded
    private IdentifierEntity identifier;
    private String password;
    private int loginAttempts;
    private LocalDateTime lastLoggedInAt;

}
