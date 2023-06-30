package me.choicore.springbootddd.domain.user.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.user.in.usecase.GetUserProfileQuery;
import me.choicore.springbootddd.domain.user.model.QueryUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserProfilePort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 사용자 프로필 정보를 조회하기 위한 서비스 구현체.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class QueryUserProfileService implements
        GetUserProfileQuery {

    private final QueryUserProfilePort queryUserProfilePort;

    @Override
    public UserProfile getUserProfile(Long userId) {
        return queryUserProfilePort.findById(userId);
    }

    @Override
    public List<UserProfile> getUserProfiles(QueryUserProfile userProfile) {
        return queryUserProfilePort.findBy(userProfile);
    }
}
