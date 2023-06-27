package me.choicore.springbootddd.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;


@Getter
@Builder
public class UserProfile {

    private UUID uuid;

    private Long userId;

    private String username;

    private String nickname;


}
