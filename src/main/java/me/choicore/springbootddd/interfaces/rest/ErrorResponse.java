package me.choicore.springbootddd.interfaces.rest;

import lombok.Builder;

public record ErrorResponse(
        int status
        , String message
        , String endpoint
) {
    @Builder
    public ErrorResponse {
    }

}
