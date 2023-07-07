package me.choicore.springbootddd.infrastructure.persistence.jpa.user.adapter;

import me.choicore.springbootddd.infrastructure.persistence.jpa.user.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<UserEntity, Long> {
}
