package me.choicore.springbootddd.domain.authentication.command;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IdentifierTest {
    @Test
    @DisplayName("이메일 주소에서 도메인을 제거한다.")
    void when_extract_local_part_then_removed_domain() throws Exception {
        // given
        Identifier identifier = new Identifier("choicore@github.com", null, IdentifierTypeHint.EMAIL);

        // when
        String localPart = identifier.extractLocalPartFromEmailAddress();

        // then
        Assertions.assertThat(localPart).isEqualTo("choicore");

    }

}