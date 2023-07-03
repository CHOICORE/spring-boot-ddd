package me.choicore.springbootddd.domain.user.out.persistence;

import me.choicore.springbootddd.domain.user.command.QueryUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;

import java.util.List;

public interface QueryUserPort {

    UserProfile findById(final Long userId);

    List<UserProfile> findByUserProfile(final QueryUserProfile user);

    List<UserProfile> findAll();

    boolean existsByUsername(final Username username);

}
