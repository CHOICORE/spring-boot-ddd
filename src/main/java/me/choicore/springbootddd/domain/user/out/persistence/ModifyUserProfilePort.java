package me.choicore.springbootddd.domain.user.out.persistence;

import me.choicore.springbootddd.domain.user.model.CreateUserProfile;
import me.choicore.springbootddd.domain.user.model.ModifyUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;


public interface ModifyUserProfilePort {

    UserProfile modifyBy(ModifyUserProfile user);

    void deleteById(Long userId);

    UserProfile createBy(CreateUserProfile user);

}
