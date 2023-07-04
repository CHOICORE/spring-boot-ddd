package me.choicore.springbootddd.infrastructure.persistence.jpa.user;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class Username {
    private String firstName;

    private String lastName;

}
