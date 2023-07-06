package me.choicore.springbootddd.domain.user.out.persistence;

import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.command.ModifyProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;


public interface ModifyUserDrivenPort {

    UserProfile modifyBy(final ModifyProfile user);

    void deleteById(final Long userId);

    UserProfile createBy(final CreateProfile user);

}
