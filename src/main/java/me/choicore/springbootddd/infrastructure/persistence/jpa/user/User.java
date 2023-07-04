package me.choicore.springbootddd.infrastructure.persistence.jpa.user;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "TBL_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false, updatable = false)
    private UUID uuid;

    @Embedded
    private Credential credential;

    @Embedded
    private UserProfile profile;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
