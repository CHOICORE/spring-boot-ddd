package me.choicore.springbootddd.domain.ports.out;

import me.choicore.springbootddd.domain.model.UserProfile;

public interface UserProfilePort {

    UserProfile findById(Long userId);

    UserProfile findBy(UserProfile user);


}
