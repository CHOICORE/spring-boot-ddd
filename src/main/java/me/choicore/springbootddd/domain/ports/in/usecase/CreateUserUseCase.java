package me.choicore.springbootddd.domain.ports.in.usecase;

import me.choicore.springbootddd.application.annotation.UseCase;
import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;


@UseCase
public interface CreateUserUseCase {

    UserProfile createBy(CreateUserProfile user);
}
