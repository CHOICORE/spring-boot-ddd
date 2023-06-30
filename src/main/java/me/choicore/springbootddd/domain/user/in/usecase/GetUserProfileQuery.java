package me.choicore.springbootddd.domain.user.in.usecase;

import me.choicore.springbootddd.domain.user.model.QueryUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;

import java.util.List;


public interface GetUserProfileQuery {

    UserProfile getUserProfile(Long userId);

    List<UserProfile> getUserProfiles(QueryUserProfile userProfile);
}
