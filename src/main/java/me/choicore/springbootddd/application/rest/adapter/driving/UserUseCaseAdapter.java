package me.choicore.springbootddd.application.rest.adapter.driving;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.service.ModifyUserProfileService;
import me.choicore.springbootddd.domain.service.QueryUserProfileService;
import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.command.ModifyProfile;
import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.in.usecase.GetUserProfileQuery;
import me.choicore.springbootddd.domain.user.in.usecase.ModifyUserProfileUseCase;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserUseCaseAdapter implements
        GetUserProfileQuery
        , ModifyUserProfileUseCase {

    private final ModifyUserProfileService modifyUserProfileService;

    private final QueryUserProfileService queryUserProfileService;

    @Override
    public UserProfile getUserProfile(final Long userId) {
        return null;
    }

    @Override
    public List<UserProfile> getUserProfiles(final QueryProfile userProfile) {
        return null;
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return null;
    }

    @Override
    public boolean existsByUsername(final Username username) {
        return false;
    }

    @Override
    public UserProfile createBy(final CreateProfile createUserProfile) {
        return null;
    }

    @Override
    public UserProfile modifyUserProfile(final ModifyProfile userProfile) {
        return null;
    }

    @Override
    public void deleteById(final Long userId) {

    }
}
