package me.choicore.springbootddd.application.rest.adapter.user;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.service.UserManagementService;
import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.command.ModifyProfile;
import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.in.usecase.GetUserProfileQuery;
import me.choicore.springbootddd.domain.user.in.usecase.ModifyUserProfileUseCase;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserUseCaseAdapter implements
        GetUserProfileQuery
        , ModifyUserProfileUseCase {

    private final UserManagementService userManagementService;


    public UserProfile getUserProfile(final Long userId) {

        return userManagementService.getUserProfile(userId);

    }


    public List<UserProfile> getUserProfiles(final QueryProfile userProfile) {
        return userManagementService.getUserProfiles(userProfile);
    }


    public List<UserProfile> getAllUserProfiles() {
        return userManagementService.getAllUserProfiles();
    }

    public boolean existsByUsername(final Username username) {
        return userManagementService.existsByUsername(username);
    }

    @Transactional
    public UserProfile createBy(final CreateProfile createUserProfile) {
        return userManagementService.createBy(createUserProfile);
    }

    @Transactional
    public void deleteById(final Long userId) {
        userManagementService.deleteById(userId);
    }

    @Transactional
    public UserProfile modifyUserProfile(final ModifyProfile modifyUserProfile) {
        return userManagementService.modifyUserProfile(modifyUserProfile);

    }
}


