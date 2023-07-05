package me.choicore.springbootddd.infrastructure.persistence.jpa.user.adapter;

import me.choicore.springbootddd.infrastructure.persistence.jpa.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<User, Long> {
}
