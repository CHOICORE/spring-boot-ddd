package me.choicore.springbootddd.domain.model;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class CreateUser {

    private String username;

    private String nickname;


}
