package me.choicore.springbootddd.domain.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.command.ModifyProfile;
import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserDrivenPort;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserDrivenPort;

import java.util.List;


@RequiredArgsConstructor
public class UserManagementService {

    private final ModifyUserDrivenPort modifyUserDrivenPort;

    private final QueryUserDrivenPort queryUserDrivenPort;

    public UserProfile getUserProfile(final Long userId) {
        return queryUserDrivenPort.findById(userId);
    }

    public List<UserProfile> getUserProfiles(final QueryProfile userProfile) {
        return queryUserDrivenPort.findByUserProfile(userProfile);
    }

    public List<UserProfile> getAllUserProfiles() {
        return queryUserDrivenPort.findAll();
    }

    public boolean existsByUsername(final Username username) {
        return queryUserDrivenPort.existsByUsername(username);
    }

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
