package me.choicore.springbootddd.domain.user.out.persistence;

import me.choicore.springbootddd.domain.user.command.CreateProfile;
import me.choicore.springbootddd.domain.user.model.BirthDate;
import me.choicore.springbootddd.domain.user.model.Gender;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.UserInMemoryDb;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.UserInMemoryDrivenAdapter;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.mapper.PersistenceInMemoryUserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ModifyUserDrivenPortTest {

    private final ModifyUserDrivenPort modifyUserDrivenPort = new UserInMemoryDrivenAdapter(new UserInMemoryDb(), new PersistenceInMemoryUserMapper());

    @Test
    @DisplayName("중복된 사용자를 생성하면 IllegalStateException이 발생한다.")
    public void test_register_duplicate_user() {
        //given
        CreateProfile user = new CreateProfile(
                "admin"
                , "admin"
                , Username.of("재형", "최")
                , "choicore"
                , Gender.MALE
                , new BirthDate(1993, 9, 22)
        );

        CreateProfile duplicateUser = new CreateProfile(
                "admin"
                , "admin"
                , Username.of("재형", "최")
                , "choicore"
                , Gender.MALE
                , new BirthDate(1993, 9, 22)
        );

        // then
        assertThatThrownBy(
                () -> {
                    // when
                    modifyUserDrivenPort.createBy(user);
                    modifyUserDrivenPort.createBy(duplicateUser);
                }
        ).isInstanceOf(IllegalStateException.class)
                .hasMessageMatching("이미 존재하는 사용자입니다.");

    }

    @Test
    @DisplayName("사용자를 생성한다.")
    public void test_create_user() {
        //given
        CreateProfile user = new CreateProfile(
                "admin"
                , "admin"
                , Username.of("재형", "최")
                , "choicore"
                , Gender.MALE
                , new BirthDate(1993, 9, 22)
        );

        // when
        UserProfile createdUser = modifyUserDrivenPort.createBy(user);

        // then
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.username().fullName()).isEqualTo("재형 최");
        assertThat(createdUser.username().firstName()).isEqualTo("재형");
        assertThat(createdUser.username().lastName()).isEqualTo("최");
        assertThat(createdUser.nickname()).isEqualTo("choicore");

    }

}
