package me.choicore.springbootddd.domain.user.in.usecase;

import me.choicore.springbootddd.domain.user.command.CreateUserProfile;
import me.choicore.springbootddd.domain.user.command.ModifyUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;


public interface ModifyUserProfileUseCase {
    UserProfile createBy(CreateUserProfile createUserProfile);

    UserProfile modifyUserProfile(ModifyUserProfile userProfile);

    void deleteById(Long userId);

}
