package me.choicore.springbootddd.domain.user.model;

public record Address(
        String mainAddress
        , String additionalAddress
        , PostalCode postalCode
) {
}
