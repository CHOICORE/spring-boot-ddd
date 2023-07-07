package me.choicore.springbootddd.application.rest.adapter.user.dto.request;

import me.choicore.springbootddd.application.rest.constant.IdentifierTypeHintDto;

public record AuthenticationRequestDto(
        String identifier,
        IdentifierTypeHintDto idTypeHint,
        String password
) {


}
