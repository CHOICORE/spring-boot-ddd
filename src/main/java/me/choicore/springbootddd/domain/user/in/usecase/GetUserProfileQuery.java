package me.choicore.springbootddd.domain.user.in.usecase;

import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;

import java.util.List;


public interface GetUserProfileQuery {

    UserProfile getUserProfile(Long userId);

    List<UserProfile> getUserProfiles(QueryProfile userProfile);

    List<UserProfile> getAllUserProfiles();

    boolean existsByUsername(Username username);
}
