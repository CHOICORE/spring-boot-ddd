package me.choicore.springbootddd.infrastructure.persistence.jpa.user;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;


@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class UserProfile {

    @Embedded
    private Username username;

    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private Gender gender;

    private LocalDate birthDate;

    @Embedded
    private Address address;
}
