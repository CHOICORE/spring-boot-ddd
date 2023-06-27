package me.choicore.springbootddd.domain.ports.in.usecase;

import me.choicore.springbootddd.application.annotation.UseCase;
import me.choicore.springbootddd.domain.model.UserProfile;


@UseCase
public interface GetUserProfileQuery {

    UserProfile getUserProfile(Long userId);
}
