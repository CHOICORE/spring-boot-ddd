package me.choicore.springbootddd.domain.ports.in.usecase;

import me.choicore.springbootddd.domain.model.QueryUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;

import java.util.List;


public interface GetUserProfileQuery {

    UserProfile getUserProfile(Long userId);

    List<UserProfile> getUserProfiles(QueryUserProfile userProfile);
}
