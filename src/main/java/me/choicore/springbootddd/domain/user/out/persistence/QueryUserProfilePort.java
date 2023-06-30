package me.choicore.springbootddd.domain.user.out.persistence;

import me.choicore.springbootddd.domain.user.model.QueryUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;

import java.util.List;

public interface QueryUserProfilePort {

    UserProfile findById(Long userId);

    List<UserProfile> findBy(QueryUserProfile user);

    List<UserProfile> findAll();

    boolean existsByUsername(String username);

}
