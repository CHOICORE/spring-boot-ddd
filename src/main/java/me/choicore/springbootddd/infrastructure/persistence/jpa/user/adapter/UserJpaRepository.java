package me.choicore.springbootddd.infrastructure.persistence.jpa.user.adapter;

import me.choicore.springbootddd.infrastructure.persistence.jpa.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {


    @Query(value = "SELECT u FROM UserEntity u " +
            "WHERE (u.credentials.identifier.email = :identifier " +
            "OR u.credentials.identifier.phoneNumber = :identifier) " +
            "AND u.credentials.password = :password")
    Optional<UserEntity> findByIdentifier(@Param("identifier") final String identifier, @Param("password") final String password);
}
