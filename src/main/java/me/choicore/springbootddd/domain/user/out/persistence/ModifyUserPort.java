package me.choicore.springbootddd.domain.user.out.persistence;

import me.choicore.springbootddd.domain.user.command.CreateUserProfile;
import me.choicore.springbootddd.domain.user.command.ModifyUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;


public interface ModifyUserPort {

    UserProfile modifyBy(final ModifyUserProfile user);

    void deleteById(final Long userId);

    UserProfile createBy(final CreateUserProfile user);

}
