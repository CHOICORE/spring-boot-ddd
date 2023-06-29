package me.choicore.springbootddd.domain.ports.in.usecase;

import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;


public interface CreateUserUseCase {

    UserProfile createBy(CreateUserProfile user);
}
