package me.choicore.springbootddd.infrastructure.persistence.jpa.authentication.adapter;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.authentication.model.Token;
import me.choicore.springbootddd.domain.authentication.out.persistence.CredentialsDrivenPort;
import me.choicore.springbootddd.infrastructure.persistence.jpa.user.UserEntity;
import me.choicore.springbootddd.infrastructure.persistence.jpa.user.adapter.UserJpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class AuthenticationJpaDrivenAdapter implements CredentialsDrivenPort {

    private final UserJpaRepository userJpaRepository;

    private final TokenJpaRepository tokenRepository;

    @Override
    public Token login(final String identifier, final String password) {

        UserEntity foundUser = userJpaRepository.findByIdentifier(identifier, password)
                                                .orElseThrow(() -> new RuntimeException("User not found"));
        return null;
    }

    @Override
    public void logout(final String token) {

    }
}

