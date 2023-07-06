package me.choicore.springbootddd.domain.user.out.persistence;

import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;

import java.util.List;

public interface QueryUserDrivenPort {

    UserProfile findById(final Long userId);

    List<UserProfile> findByUserProfile(final QueryProfile user);

    List<UserProfile> findAll();

    boolean existsByUsername(final Username username);

}
