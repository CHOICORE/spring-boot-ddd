package me.choicore.springbootddd.infrastructure.persistence.jpa.user;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Embeddable
public class IdentifierEntity {

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;
}
