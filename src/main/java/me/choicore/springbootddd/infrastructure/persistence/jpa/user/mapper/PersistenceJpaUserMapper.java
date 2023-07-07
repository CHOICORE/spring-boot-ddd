package me.choicore.springbootddd.infrastructure.persistence.jpa.user.mapper;

import me.choicore.springbootddd.domain.user.model.Gender;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.infrastructure.persistence.jpa.user.GenderEntity;

import static me.choicore.springbootddd.domain.user.model.Gender.FEMALE;
import static me.choicore.springbootddd.domain.user.model.Gender.MALE;
import static me.choicore.springbootddd.infrastructure.persistence.jpa.user.GenderEntity.F;
import static me.choicore.springbootddd.infrastructure.persistence.jpa.user.GenderEntity.M;


public sealed class PersistenceJpaUserMapper permits
        PersistenceJpaUserMapper.UserDomainToEntity
        , PersistenceJpaUserMapper.UserEntityToDomain {


    private final UserProfile.UserProfileBuilder builder = UserProfile.builder();

    public Gender toGenderDomain(final GenderEntity genderEntity) {
        return switch (genderEntity) {
            case M -> MALE;
            case F -> FEMALE;
        };
    }

    public GenderEntity toGenderEntity(final Gender gender) {
        return switch (gender) {
            case MALE -> M;
            case FEMALE -> F;
        };
    }

    final static public class UserDomainToEntity extends PersistenceJpaUserMapper {

    }

    final static public class UserEntityToDomain extends PersistenceJpaUserMapper {

    }


}
