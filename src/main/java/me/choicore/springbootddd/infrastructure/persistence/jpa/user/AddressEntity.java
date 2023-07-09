package me.choicore.springbootddd.infrastructure.persistence.jpa.user;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class AddressEntity {
    private String mainAddress;
    private String additionalAddress;
    private String postalCode;
}
