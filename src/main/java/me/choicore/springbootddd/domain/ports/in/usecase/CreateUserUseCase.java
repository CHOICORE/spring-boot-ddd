package me.choicore.springbootddd.domain.ports.in.usecase;

import me.choicore.springbootddd.application.annotation.UseCase;
import me.choicore.springbootddd.domain.model.CreateUser;


@UseCase
public interface CreateUserUseCase {

    CreateUser register(CreateUser user);
}
