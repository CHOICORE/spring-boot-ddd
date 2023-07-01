package me.choicore.springbootddd.domain.user.out;


import me.choicore.springbootddd.domain.user.model.QueryUserProfile;
import me.choicore.springbootddd.domain.user.model.UserProfile;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserPort;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.InMemoryDb;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.UserManagementInMemoryAdapter;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.mapper.PersistenceInMemoryUserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QueryUserPortTest {

    private final QueryUserPort queryUserPort = new UserManagementInMemoryAdapter(InMemoryDb.setupTestModule(), new PersistenceInMemoryUserMapper());

    @Test
    @DisplayName("ID로 사용자를 조회한다.")
    void find_by_id() {

        // given
        Long userId = 1L;

        // when
        UserProfile userProfile = queryUserPort.findById(userId);

        // then
        assertThat(userProfile).isNotNull();
        assertThat(userProfile.username()).isEqualTo("최재형");
        assertThat(userProfile.nickname()).isEqualTo("choicore");
    }

    @Test
    @DisplayName("사용자 정보로 사용자를 조회한다.")
    void find_by_attributes() {

        // given
        QueryUserProfile queryByUsername = QueryUserProfile.builder()
                                                           .username("최재형")
                                                           .build();

        QueryUserProfile queryByNickname = QueryUserProfile.builder()
                                                           .nickname("choicore")
                                                           .build();

        QueryUserProfile queryByBirthYear = QueryUserProfile.builder()
                                                            .birthYear(1993)
                                                            .build();

        // when
        List<UserProfile> foundByUsername = queryUserPort.findBy(queryByUsername);

        List<UserProfile> foundByNickname = queryUserPort.findBy(queryByNickname);

        List<UserProfile> foundByBirthYear = queryUserPort.findBy(queryByBirthYear);


        // then
        assertThat(foundByUsername).isNotNull();
        assertThat(foundByUsername.size()).isEqualTo(1);

        assertThat(foundByNickname).isNotNull();
        assertThat(foundByNickname.size()).isEqualTo(1);

        assertThat(foundByBirthYear).isNotNull();
        assertThat(foundByBirthYear.size()).isEqualTo(1);
    }

}