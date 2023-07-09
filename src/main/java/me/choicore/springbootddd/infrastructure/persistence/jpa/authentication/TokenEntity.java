package me.choicore.springbootddd.infrastructure.persistence.jpa.authentication;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;


@Entity
@Table(name = "TBL_AUTH_TOKEN")
public class TokenEntity {


    @Id
    private Long id;
    private String accessToken;
    private String refreshToken;
    private String issuer;
    private String scope;
    private LocalDateTime expiresAt;
    private LocalDateTime issuedAt;

    public TokenEntity() {
    }
}
