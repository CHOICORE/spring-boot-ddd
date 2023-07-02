package me.choicore.springbootddd.domain.user.out;

import me.choicore.springbootddd.domain.user.model.*;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserPort;
import me.choicore.springbootddd.infrastructure.persistence.user.inmemory.UserManagementInMemoryAdapter;
import me.choicore.springbootddd.infrastructure.persistence.user.inmemory.mapper.PersistenceInMemoryUserMapper;
import me.choicore.springbootddd.infrastructure.persistence.user.inmemory.repository.UserInMemoryDb;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ModifyUserPortTest {

    private final ModifyUserPort modifyUserPort = new UserManagementInMemoryAdapter(new UserInMemoryDb(), new PersistenceInMemoryUserMapper());

    @Test
    @DisplayName("중복된 사용자를 생성하면 IllegalStateException이 발생한다.")
    public void test_register_duplicate_user() {
        //given
        CreateUserProfile user = new CreateUserProfile(
                "admin"
                , "admin"
                , FullName.of("재형", "최")
                , "choicore"
                , Gender.MALE
                , new BirthDate(1993, 9, 22)
        );

        CreateUserProfile duplicateUser = new CreateUserProfile(
                "admin"
                , "admin"
                , FullName.of("재형", "최")
                , "choicore"
                , Gender.MALE
                , new BirthDate(1993, 9, 22)
        );

        // then
        assertThatThrownBy(
                () -> {
                    // when
                    modifyUserPort.createBy(user);
                    modifyUserPort.createBy(duplicateUser);
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
                , FullName.of("재형", "최")
                , "choicore"
                , Gender.MALE
                , new BirthDate(1993, 9, 22)
        );

        // when
        UserProfile createdUser = modifyUserPort.createBy(user);

        // then
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.fullName().fullName()).isEqualTo("admin");
        assertThat(createdUser.nickname()).isEqualTo("admin");

    }

}