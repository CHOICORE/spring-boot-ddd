package me.choicore.springbootddd.domain.ports.in.usecase;

import me.choicore.springbootddd.domain.model.ModifyUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;


public interface ModifyUserProfileUseCase {

    UserProfile modifyUserProfile(ModifyUserProfile userProfile);
}
