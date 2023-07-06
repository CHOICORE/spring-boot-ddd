package me.choicore.springbootddd.domain.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserDrivenPort;

import java.util.List;

/**
 * <p>
 * 사용자 프로필 정보를 조회하기 위한 서비스 구현체.
 * </p>
 */

@RequiredArgsConstructor
public class QueryUserProfileService {

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
}
