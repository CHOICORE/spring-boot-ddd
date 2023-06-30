package me.choicore.springbootddd.domain.user.out;

import me.choicore.springbootddd.domain.user.model.BirthDate;
import me.choicore.springbootddd.domain.user.model.CreateUserProfile;
import me.choicore.springbootddd.domain.user.model.Gender;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserProfilePort;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.InMemoryDb;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.UserManagementInMemoryAdapter;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.mapper.PersistenceUserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ModifyUserProfilePortTest {

    private final ModifyUserProfilePort modifyUserProfilePort = new UserManagementInMemoryAdapter(new InMemoryDb(), new PersistenceUserMapper());

    @Test
    @DisplayName("중복된 사용자를 생성하면 IllegalStateException이 발생한다.")
    public void test_register_duplicate_user() {
        //given
        CreateUserProfile user = new CreateUserProfile(
                "admin"
                , "admin"
                , Gender.MALE
                , new BirthDate(1993, 9, 22)
        );

        CreateUserProfile duplicateUser = new CreateUserProfile(
                "admin"
                , "admin"
                , Gender.MALE
                , new BirthDate(1993, 9, 22)
        );

        // then
        assertThatThrownBy(
                () -> {
                    // when
                    modifyUserProfilePort.createBy(user);
                    modifyUserProfilePort.createBy(duplicateUser);
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
                , Gender.MALE
                , new BirthDate(1993, 9, 22)
        );

        // when
        UserProfile createdUser = modifyUserProfilePort.createBy(user);

        // then
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.username()).isEqualTo("admin");
        assertThat(createdUser.nickname()).isEqualTo("admin");

    }

}