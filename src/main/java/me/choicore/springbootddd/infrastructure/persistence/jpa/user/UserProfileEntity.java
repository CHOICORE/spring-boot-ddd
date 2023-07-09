package me.choicore.springbootddd.infrastructure.persistence.jpa.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;


@Getter
@Embeddable
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class UserProfileEntity {

    @Embedded
    private UsernameEntity username;

    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(length = 2)
    private GenderEntity gender;

    private LocalDate birthDate;

    @Embedded
    private AddressEntity address;
}
