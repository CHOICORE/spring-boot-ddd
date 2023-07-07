package me.choicore.springbootddd.domain.user.out.persistence;


import me.choicore.springbootddd.domain.user.command.QueryProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.model.Username;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.UserInMemoryDb;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.UserManagementInMemoryDrivenAdapter;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.mapper.PersistenceInMemoryUserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QueryUserDrivenPortTest {

    private final QueryUserDrivenPort queryUserDrivenPort = new UserManagementInMemoryDrivenAdapter(UserInMemoryDb.testInstance(), new PersistenceInMemoryUserMapper());

    @Test
    @DisplayName("ID로 사용자를 조회한다.")
    void find_by_id() {

        // given
        Long userId = 1L;

        // when
        UserProfile userProfile = queryUserDrivenPort.findById(userId);

        // then
        assertThat(userProfile).isNotNull();
        assertThat(userProfile.userId()).isEqualTo(userId);
        assertThat(userProfile.username().fullName()).isEqualTo("재형 최");
        assertThat(userProfile.username().firstName()).isEqualTo("재형");
        assertThat(userProfile.username().lastName()).isEqualTo("최");
        assertThat(userProfile.nickname()).isEqualTo("choicore");
    }

    @Test
    @DisplayName("사용자 정보로 사용자를 조회한다.")
    void find_by_attributes() {

        // given
        QueryProfile queryByUsername = QueryProfile.builder()
                                                   .username(Username.of("재형", "최"))
                                                   .build();

        QueryProfile queryByNickname = QueryProfile.builder()
                                                   .nickname("choicore")
                                                   .build();

        QueryProfile queryByBirthYear = QueryProfile.builder()
                                                    .birthYear(1993)
                                                    .build();

        // when
        List<UserProfile> foundByUsername = queryUserDrivenPort.findByUserProfile(queryByUsername);

        List<UserProfile> foundByNickname = queryUserDrivenPort.findByUserProfile(queryByNickname);

        List<UserProfile> foundByBirthYear = queryUserDrivenPort.findByUserProfile(queryByBirthYear);


        // then
        assertThat(foundByUsername).isNotNull();
        assertThat(foundByUsername.size()).isEqualTo(1);

        assertThat(foundByNickname).isNotNull();
        assertThat(foundByNickname.size()).isEqualTo(1);

        assertThat(foundByBirthYear).isNotNull();
        assertThat(foundByBirthYear.size()).isEqualTo(1);
    }

}
