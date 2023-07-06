package me.choicore.springbootddd.domain.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.command.ModifyProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserDrivenPort;


/**
 * <p>
 * 사용자 프로필 정보를 관리하기 위한 서비스 구현체.
 * </p>
 */

@RequiredArgsConstructor
public class ModifyUserProfileService {

    private final ModifyUserDrivenPort modifyUserDrivenPort;

    public UserProfile createBy(final CreateProfile createUserProfile) {
        return modifyUserDrivenPort.createBy(createUserProfile);
    }

    public void deleteById(final Long userId) {
        modifyUserDrivenPort.deleteById(userId);
    }


    public UserProfile modifyUserProfile(final ModifyProfile modifyUserProfile) {
        return modifyUserDrivenPort.modifyBy(modifyUserProfile);
    }
}
