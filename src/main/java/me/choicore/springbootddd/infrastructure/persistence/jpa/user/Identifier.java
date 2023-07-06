package me.choicore.springbootddd.infrastructure.persistence.jpa.user;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class Identifier {
    private String email;
    private String mobile;
}
