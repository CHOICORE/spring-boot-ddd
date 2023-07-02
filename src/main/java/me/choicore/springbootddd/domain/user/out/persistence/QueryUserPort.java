package me.choicore.springbootddd.domain.user.out.persistence;

import me.choicore.springbootddd.domain.user.model.QueryUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;

import java.util.List;

public interface QueryUserPort {

    UserProfile findById(final Long userId);

    List<UserProfile> findBy(final QueryUserProfile user);

    List<UserProfile> findAll();

    boolean existsByUsername(final String username);

}
