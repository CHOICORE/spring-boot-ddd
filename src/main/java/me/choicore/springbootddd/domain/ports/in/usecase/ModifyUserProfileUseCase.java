package me.choicore.springbootddd.domain.ports.in.usecase;

import me.choicore.springbootddd.domain.model.UserProfile;


public interface ModifyUserProfileUseCase {

    UserProfile modifyUserProfile(UserProfile userProfile);
}
