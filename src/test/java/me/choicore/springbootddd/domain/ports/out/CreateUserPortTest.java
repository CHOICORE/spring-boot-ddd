package me.choicore.springbootddd.domain.ports.out;

import me.choicore.springbootddd.domain.model.CreateUser;
import me.choicore.springbootddd.infrastructure.persistence.UserManagementInMemoryAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CreateUserPortTest {

    private final CreateUserPort port = new UserManagementInMemoryAdapter();


    @Test
    @DisplayName("중복된 사용자를 생성하면 IllegalStateException이 발생한다.")
    public void test_create_duplicate_user() {
        //given
        CreateUser user = CreateUser.builder()
                                    .username("admin")
                                    .nickname("admin")
                                    .build();

        CreateUser sameUser = CreateUser.builder()
                                        .username("admin")
                                        .nickname("admin")
                                        .build();


        // then
        assertThatThrownBy(() -> {
            // when
            port.createBy(user);
            port.createBy(sameUser);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageMatching("이미 존재하는 사용자입니다.");

    }

    @Test
    @DisplayName("사용자를 생성한다.")
    public void test_create_user() {
        //given
        CreateUser user = CreateUser.builder()
                                    .username("admin")
                                    .nickname("admin")
                                    .build();


        // when
        Optional<CreateUser> savedUser = port.createBy(user);


        // then
        assertThat(savedUser).isPresent();
        assertThat(savedUser.get().getUsername()).isEqualTo(user.getUsername());

    }

    @Test
    @DisplayName("사용자 이름으로 사용자가 존재하는지 확인한다.")
    public void test_exists_by_username() {

        // given
        CreateUser user = CreateUser.builder()
                                    .username("admin")
                                    .nickname("admin")
                                    .build();
        port.createBy(user);

        // when
        boolean exists = port.existsByUsername("admin");
        boolean exists2 = port.existsByUsername("admin ");

        // then
        assertThat(exists).isTrue();
        assertThat(exists2).isFalse();
    }


}