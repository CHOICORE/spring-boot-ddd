package me.choicore.springbootddd.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InboundPortValidationTest {


    @Test
    @DisplayName("사용자 등록을 위한 인바운드 포트의 유효성 검사를 수행한다.")
    void test_create_user_instance() throws Exception {

        // then
        Assertions.assertThatThrownBy(
                () ->
                {
                    // when
                    CreateUserProfile.builder()
                                     .username(null)
                                     .nickname(null)
                                     .build();
                }
        ).isInstanceOf(IllegalArgumentException.class);

        // then
        Assertions.assertThatThrownBy(
                () -> {
                    // when
                    CreateUserProfile.builder()
                                     .username("")
                                     .nickname("")
                                     .build();
                }
        ).isInstanceOf(IllegalArgumentException.class);


        // then
        Assertions.assertThatThrownBy(
                () -> {
                    // when
                    new CreateUserProfile("admin", "");
                }
        ).isInstanceOf(IllegalArgumentException.class);


        // when
        Assertions.assertThatThrownBy(
                () -> {
                    // when
                    new CreateUserProfile("", "admin");
                }
        ).isInstanceOf(IllegalArgumentException.class);

        // given & when
        CreateUserProfile admin = new CreateUserProfile("admin", "admin");

        Assertions.assertThat(admin).isNotNull();
    }
}