package me.choicore.springbootddd.domain.user.in.usecase;

import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.command.ModifyProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;


public interface ModifyUserProfileUseCase {
    UserProfile createBy(CreateProfile createUserProfile);

    UserProfile modifyUserProfile(ModifyProfile userProfile);

    void deleteById(Long userId);

}
