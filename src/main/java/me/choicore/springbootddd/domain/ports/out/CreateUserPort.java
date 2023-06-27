package me.choicore.springbootddd.domain.ports.out;

import me.choicore.springbootddd.domain.model.CreateUser;

import java.util.Optional;

public interface CreateUserPort {

    Optional<CreateUser> createBy(CreateUser user);



    boolean existsByUsername(String username);
}
