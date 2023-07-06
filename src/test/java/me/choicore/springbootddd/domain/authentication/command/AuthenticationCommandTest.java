package me.choicore.springbootddd.domain.authentication.command;

import me.choicore.springbootddd.domain.authentication.model.Identifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AuthenticationCommandTest {
    @Test
    @DisplayName("이메일 주소에서 도메인을 제거한다.")
    void when_extract_local_part_then_removed_domain() throws Exception {
        // given
        Identifier identifier = new Identifier("choicore@github.com", "01012341234", "1q2w3e4r!");

        // when
        String loginId = identifier.identifier();


        // then
        Assertions.assertThat(loginId).isEqualTo("choicore");

    }

}