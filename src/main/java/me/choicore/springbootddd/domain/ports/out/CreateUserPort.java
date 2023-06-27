package me.choicore.springbootddd.domain.ports.out;

import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;

public interface CreateUserPort {

    UserProfile createBy(CreateUserProfile user);

    boolean existsByUsername(String username);
}
