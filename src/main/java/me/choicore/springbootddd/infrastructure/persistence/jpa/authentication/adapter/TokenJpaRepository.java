package me.choicore.springbootddd.infrastructure.persistence.jpa.authentication.adapter;

import me.choicore.springbootddd.infrastructure.persistence.jpa.authentication.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TokenJpaRepository extends JpaRepository<TokenEntity, Long> {
}
