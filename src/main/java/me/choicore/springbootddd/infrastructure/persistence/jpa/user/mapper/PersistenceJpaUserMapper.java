package me.choicore.springbootddd.infrastructure.persistence.jpa.user.mapper;

import me.choicore.springbootddd.domain.user.model.UserProfile;

public sealed class PersistenceJpaUserMapper permits
        PersistenceJpaUserMapper.UserDomainToEntity
        , PersistenceJpaUserMapper.UserEntityToDomain {
    private final UserProfile.UserProfileBuilder builder = UserProfile.builder();

    final static public class UserDomainToEntity extends PersistenceJpaUserMapper {

    }

    final static public class UserEntityToDomain extends PersistenceJpaUserMapper {

    }


}
