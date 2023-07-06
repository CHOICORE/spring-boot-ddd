package me.choicore.springbootddd.infrastructure.persistence.jpa.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;


@Getter
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class Credential {

    @Embedded
    private Identifier identifier;
    private String password;
    private int loginAttempts;
    private LocalDateTime lastLoggedInAt;

}
