package me.choicore.springbootddd.domain.ports.out;

import me.choicore.springbootddd.domain.model.UserProfile;

public interface ModifyUserPort {
    UserProfile modifyBy(UserProfile user);

}
