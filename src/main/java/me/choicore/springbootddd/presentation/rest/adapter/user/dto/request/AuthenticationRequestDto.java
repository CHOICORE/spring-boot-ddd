package me.choicore.springbootddd.presentation.rest.adapter.user.dto.request;

import me.choicore.springbootddd.presentation.rest.constant.IdentifierTypeHintDto;

public record AuthenticationRequestDto(
        String identifier,
        IdentifierTypeHintDto idTypeHint,
        String password
) {


}
