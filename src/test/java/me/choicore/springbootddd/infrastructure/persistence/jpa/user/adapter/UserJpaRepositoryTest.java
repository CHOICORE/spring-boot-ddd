package me.choicore.springbootddd.infrastructure.persistence.jpa.user.adapter;

import me.choicore.springbootddd.infrastructure.persistence.jpa.user.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
@Transactional
class UserJpaRepositoryTest {

    @Autowired
    UserJpaRepository userJpaRepository;

    @BeforeEach
    void setUp() {
        UserEntity createUser = UserEntity.builder()
                .credentials(CredentialsEntity.builder()
                        .identifier(new IdentifierEntity("choicore@github.com", "01012341234"))
                        .password("1q2w3e4r!")
                        .loginAttempts(0)
                        .lastLoggedInAt(null)
                        .build())
                .profile(UserProfileEntity.builder()
                        .username(new UsernameEntity("Jae-hyeong", "Choi"))
                        .nickname("choicore")
                        .gender(GenderEntity.M)
                        .birthDate(LocalDate.of(1993, 9, 22))
                        .address(new AddressEntity("기본 주소", "상세 주소", "123-456"))
                        .build())
                .userStatus(UserStatusEntity.ACTIVE)
                .createdAt(LocalDateTime.now())
                .build();
        userJpaRepository.save(createUser);
    }

    @Test
    @DisplayName("중복 사용자 등록 시 익셉션이 발생한다.")
    void duplicate_identifier_verify() throws Exception {

        // given
        UserEntity createUser = UserEntity.builder()
                .credentials(CredentialsEntity.builder()
                        .identifier(new IdentifierEntity("choicore@github.com", "01012341234"))
                        .password("1q2w3e4r!")
                        .loginAttempts(0)
                        .lastLoggedInAt(null)
                        .build())
                .profile(UserProfileEntity.builder()
                        .username(new UsernameEntity("Jae-hyeong", "Choi"))
                        .nickname("choicore")
                        .gender(GenderEntity.M)
                        .birthDate(LocalDate.of(1993, 9, 22))
                        .address(new AddressEntity("기본 주소", "상세 주소", "123-456"))
                        .build())
                .userStatus(UserStatusEntity.ACTIVE)
                .createdAt(LocalDateTime.now())
                .build();


        // then
        assertThatThrownBy(
                () -> {
                    // when
                    userJpaRepository.save(createUser);
                }
        ).isInstanceOf(DataIntegrityViolationException.class);

    }

    @Test
    @DisplayName("사용자 식별 값으로 사용자 정보를 조회한다.")
    void find_by_identifier() throws Exception {
        // given

        String password = "1q2w3e4r!";
        String email = "choicore@github.com";
        String phoneNumber = "01012341234";


        // when
        Optional<UserEntity> foundUserByEmail = userJpaRepository.findByIdentifier(email, password);
        Optional<UserEntity> foundUserByPhoneNumber = userJpaRepository.findByIdentifier(phoneNumber, password);

        // then
        assertThat(foundUserByEmail).isPresent();
        assertThat(foundUserByPhoneNumber).isPresent();
        assertThat(foundUserByEmail.get().getId()).isEqualTo(foundUserByPhoneNumber.get().getId());


    }

}