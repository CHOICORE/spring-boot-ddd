package me.choicore.springbootddd.domain.ports.out;

import me.choicore.springbootddd.domain.model.QueryUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;

import java.util.List;

public interface UserProfilePort {

    UserProfile findById(Long userId);

    List<UserProfile> findBy(QueryUserProfile user);
}
