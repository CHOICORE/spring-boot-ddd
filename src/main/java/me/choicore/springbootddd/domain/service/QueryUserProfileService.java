package me.choicore.springbootddd.domain.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.in.usecase.GetUserProfileQuery;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 사용자 프로필 정보를 조회하기 위한 서비스 구현체.
 * </p>
 */

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QueryUserProfileService implements
        GetUserProfileQuery {

    private final QueryUserPort queryUserPort;


    @Override
    public UserProfile getUserProfile(final Long userId) {
        return queryUserPort.findById(userId);
    }

    @Override
    public List<UserProfile> getUserProfiles(final QueryProfile userProfile) {
        return queryUserPort.findByUserProfile(userProfile);
    }


    @Override
    public List<UserProfile> getAllUserProfiles() {
        return queryUserPort.findAll();
    }

    @Override
    public boolean existsByUsername(final Username username) {
        return queryUserPort.existsByUsername(username);
    }
}
