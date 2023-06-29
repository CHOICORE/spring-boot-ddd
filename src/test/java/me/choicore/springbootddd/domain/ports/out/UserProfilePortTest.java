package me.choicore.springbootddd.domain.ports.out;

import me.choicore.springbootddd.domain.model.BirthDate;
import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.QueryUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;
import me.choicore.springbootddd.infrastructure.persistence.UserManagementInMemoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserProfilePortTest {
    private final UserProfilePort userProfilePort;
    private final CreateUserPort createUserPort;

    {
        UserManagementInMemoryAdapter userManagementInMemoryAdapter = new UserManagementInMemoryAdapter();
        userProfilePort = userManagementInMemoryAdapter;
        createUserPort = userManagementInMemoryAdapter;
    }

    @BeforeEach
    void setUp() {
        CreateUserProfile createUserProfile = CreateUserProfile.builder()
                                                               .username("최재형")
                                                               .nickname("choicore")
                                                               .birthDate(new BirthDate(1993, 9, 22))
                                                               .build();
        createUserPort.createBy(createUserProfile);
    }

    @Test
    void findById() {

        // given
        Long userId = 1L;

        // when
        UserProfile userProfile = userProfilePort.findById(userId);

        // then
        assertThat(userProfile).isNotNull();
        assertThat(userProfile.username()).isEqualTo("최재형");
        assertThat(userProfile.nickname()).isEqualTo("choicore");
    }

    @Test
    void findBy() {

        // given
        QueryUserProfile name = QueryUserProfile.builder()
                                                .username("최재형")
                                                .build();

        // when
        List<UserProfile> userProfiles = userProfilePort.findBy(name);

        // then
        assertThat(userProfiles).isNotNull();
        assertThat(userProfiles.size()).isEqualTo(1);
    }
}