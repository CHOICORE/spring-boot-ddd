package me.choicore.springbootddd.interfaces.rest.user.ports.in;

import lombok.Getter;


@Getter
public class CreateUserRequest {
    private String username;
    private String nickname;
}
