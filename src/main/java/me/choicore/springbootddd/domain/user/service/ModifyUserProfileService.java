package me.choicore.springbootddd.domain.user.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.user.in.usecase.ModifyUserProfileUseCase;
import me.choicore.springbootddd.domain.user.model.CreateUserProfile;
import me.choicore.springbootddd.domain.user.model.ModifyUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserProfilePort;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 사용자 프로필 정보를 관리하기 위한 서비스 구현체.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class ModifyUserProfileService implements
        ModifyUserProfileUseCase {

    private final ModifyUserProfilePort modifyUserPort;

    @Override
    public UserProfile createBy(CreateUserProfile createUserProfile) {
        return modifyUserPort.createBy(createUserProfile);
    }

    @Override
    public void deleteById(Long userId) {
        modifyUserPort.deleteById(userId);
    }

    @Override
    public UserProfile modifyUserProfile(ModifyUserProfile modifyUserProfile) {
        return modifyUserPort.modifyBy(modifyUserProfile);
    }
}
