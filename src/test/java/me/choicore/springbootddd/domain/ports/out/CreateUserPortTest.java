package me.choicore.springbootddd.domain.ports.out;

import me.choicore.springbootddd.domain.model.BirthDate;
import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;
import me.choicore.springbootddd.infrastructure.persistence.UserManagementInMemoryAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CreateUserPortTest {

    private final CreateUserPort createUserPort = new UserManagementInMemoryAdapter();

    @Test
    @DisplayName("중복된 사용자를 생성하면 IllegalStateException이 발생한다.")
    public void test_register_duplicate_user() {
        //given
        CreateUserProfile user = new CreateUserProfile(
                "admin"
                , "admin"
                , new BirthDate(1993, 9, 22)
        );

        CreateUserProfile duplicateUser = new CreateUserProfile(
                "admin"
                , "admin"
                , new BirthDate(1993, 9, 22)
        );

        // then
        assertThatThrownBy(
                () -> {
                    // when
                    createUserPort.createBy(user);
                    createUserPort.createBy(duplicateUser);
                }
        ).isInstanceOf(IllegalStateException.class)
         .hasMessageMatching("이미 존재하는 사용자입니다.");

    }

    @Test
    @DisplayName("사용자를 생성한다.")
    public void test_create_user() {
        //given
        CreateUserProfile user = new CreateUserProfile(
                "admin"
                , "admin"
                , new BirthDate(1993, 9, 22)
        );

        // when
        UserProfile createdUser = createUserPort.createBy(user);

        // then
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.username()).isEqualTo("admin");
        assertThat(createdUser.nickname()).isEqualTo("admin");

    }

    @Test
    @DisplayName("사용자 이름으로 사용자가 존재하는지 확인한다.")
    public void test_exists_by_username() {

        // given
        CreateUserProfile user = new CreateUserProfile(
                "admin"
                , "admin"
                , new BirthDate(1993, 9, 22)
        );

        createUserPort.createBy(user);

        // when
        boolean trueExpected = createUserPort.existsByUsername("admin");
        // then
        assertThat(trueExpected).isTrue();

        // when
        boolean falseExpected = createUserPort.existsByUsername("admin ");
        // then
        assertThat(falseExpected).isFalse();

    }


}