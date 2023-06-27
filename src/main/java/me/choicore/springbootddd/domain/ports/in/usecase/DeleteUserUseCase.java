package me.choicore.springbootddd.domain.ports.in.usecase;

import me.choicore.springbootddd.application.annotation.UseCase;


@UseCase
public interface DeleteUserUseCase {

    void deleteById(Long userId);
}
