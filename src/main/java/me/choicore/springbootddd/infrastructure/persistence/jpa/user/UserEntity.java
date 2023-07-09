package me.choicore.springbootddd.infrastructure.persistence.jpa.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "TBL_USER")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Embedded
    private CredentialsEntity credentials;

    @Embedded
    private UserProfileEntity profile;

    @Enumerated(EnumType.STRING)
    private UserStatusEntity userStatus;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
