package me.choicore.springbootddd.infrastructure.persistence.jpa.user.adapter;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.command.ModifyProfile;
import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserDrivenPort;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserDrivenPort;
import me.choicore.springbootddd.infrastructure.persistence.jpa.user.mapper.PersistenceJpaUserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class UserJpaDrivenAdapter implements
        ModifyUserDrivenPort
        , QueryUserDrivenPort {

    private final UserJpaRepository userJpaRepository;
    private final PersistenceJpaUserMapper persistenceJpaUserMapper;

    @Override
    public UserProfile createBy(final CreateProfile user) {
        // userJpaRepository.save();
        return null;
    }

    @Override
    public UserProfile modifyBy(final ModifyProfile user) {
        return null;
    }

    @Override
    public void deleteById(final Long userId) {

    }


    @Override
    public UserProfile findById(final Long userId) {
        return null;
    }

    @Override
    public List<UserProfile> findByUserProfile(final QueryProfile user) {
        return null;
    }

    @Override
    public List<UserProfile> findAll() {
        return null;
    }

    @Override
    public boolean existsByUsername(final Username username) {
        return false;
    }
}
