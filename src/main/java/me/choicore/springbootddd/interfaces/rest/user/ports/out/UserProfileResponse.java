package me.choicore.springbootddd.interfaces.rest.user.ports.out;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;


@Getter
@Builder
public class UserProfileResponse {


    private UUID id;

    private String nickname;

    private String username;


}
