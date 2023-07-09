package me.choicore.springbootddd.application.configuration;

import me.choicore.springbootddd.domain.authentication.out.persistence.CredentialsDrivenPort;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserDrivenPort;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserDrivenPort;
import me.choicore.springbootddd.infrastructure.persistence.jpa.authentication.adapter.AuthenticationJpaDrivenAdapter;
import me.choicore.springbootddd.infrastructure.persistence.jpa.authentication.adapter.TokenJpaRepository;
import me.choicore.springbootddd.infrastructure.persistence.jpa.user.adapter.UserJpaDrivenAdapter;
import me.choicore.springbootddd.infrastructure.persistence.jpa.user.adapter.UserJpaRepository;
import me.choicore.springbootddd.infrastructure.persistence.jpa.user.mapper.PersistenceJpaUserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DrivenPortConfiguration {

    @Bean
    public CredentialsDrivenPort credentialsDrivenPort(UserJpaRepository userJpaRepository, TokenJpaRepository tokenJpaRepository) {
        return new AuthenticationJpaDrivenAdapter(userJpaRepository, tokenJpaRepository);
    }

    @Bean
    public QueryUserDrivenPort queryUserDrivenPort(UserJpaRepository userJpaRepository, PersistenceJpaUserMapper persistenceJpaUserMapper) {
        return new UserJpaDrivenAdapter(userJpaRepository, persistenceJpaUserMapper);
    }

    @Bean
    public ModifyUserDrivenPort modifyUserDrivenPort(UserJpaRepository userJpaRepository, PersistenceJpaUserMapper persistenceJpaUserMapper) {
        return new UserJpaDrivenAdapter(userJpaRepository, persistenceJpaUserMapper);
    }

}

