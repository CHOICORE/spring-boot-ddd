package me.choicore.springbootddd.domain.ports.out;

import me.choicore.springbootddd.domain.model.UserProfile;

public interface DeleteUserPort {

    void deleteBy(UserProfile user);

    void deleteById(Long userId);
}
