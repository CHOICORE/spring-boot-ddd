package me.choicore.springbootddd.domain.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.command.ModifyProfile;
import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserPort;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserPort;

import java.util.List;


@RequiredArgsConstructor
public class UserManagementService {

    private final ModifyUserPort modifyUserPort;

    private final QueryUserPort queryUserPort;

    public UserProfile getUserProfile(final Long userId) {
        return queryUserPort.findById(userId);
    }

    public List<UserProfile> getUserProfiles(final QueryProfile userProfile) {
        return queryUserPort.findByUserProfile(userProfile);
    }

    public List<UserProfile> getAllUserProfiles() {
        return queryUserPort.findAll();
    }

    public boolean existsByUsername(final Username username) {
        return queryUserPort.existsByUsername(username);
    }

    public UserProfile createBy(final CreateProfile createUserProfile) {
        return modifyUserPort.createBy(createUserProfile);
    }

    public void deleteById(final Long userId) {
        modifyUserPort.deleteById(userId);
    }


    public UserProfile modifyUserProfile(final ModifyProfile modifyUserProfile) {
        return modifyUserPort.modifyBy(modifyUserProfile);
    }


}
