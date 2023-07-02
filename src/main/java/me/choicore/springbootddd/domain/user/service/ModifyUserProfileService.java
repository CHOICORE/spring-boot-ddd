package me.choicore.springbootddd.domain.user.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.user.in.usecase.ModifyUserProfileUseCase;
import me.choicore.springbootddd.domain.user.model.CreateUserProfile;
import me.choicore.springbootddd.domain.user.model.ModifyUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserPort;
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

    private final ModifyUserPort modifyUserPort;

    @Override
    public UserProfile createBy(final CreateUserProfile createUserProfile) {
        return modifyUserPort.createBy(createUserProfile);
    }

    @Override
    public void deleteById(final Long userId) {
        modifyUserPort.deleteById(userId);
    }

    @Override
    public UserProfile modifyUserProfile(final ModifyUserProfile modifyUserProfile) {
        return modifyUserPort.modifyBy(modifyUserProfile);
    }
}
