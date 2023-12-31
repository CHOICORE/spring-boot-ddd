package me.choicore.springbootddd.domain.user.model;

import me.choicore.springbootddd.domain.user.command.CreateProfile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InboundPortValidationTest {

    @Test
    @DisplayName("사용자의 생년월일 정보를 위한 인바운드 포트의 유효성 검사를 수행한다.")
    void test_user_day_of_birth_instance() {

        // then
        assertThatThrownBy(
                () ->
                {
                    // when
                    BirthDate.builder()
                             .year(0)
                             .month(0)
                             .dayOfMonth(0)
                             .build();
                }
        ).isInstanceOf(IllegalArgumentException.class);

        // then
        assertThatThrownBy(
                () -> {
                    // when
                    BirthDate.builder()
                             .year(2021)
                             .month(0)
                             .dayOfMonth(0)
                             .build();
                }
        ).isInstanceOf(IllegalArgumentException.class);

        // then
        BirthDate dayOfBirth = new BirthDate(2021, 9, 22);

        assertThat(dayOfBirth).isNotNull();
        assertThat(dayOfBirth.dateOfBirth()).isEqualTo("2021-09-22");
    }


    @Test
    @DisplayName("사용자 등록을 위한 인바운드 포트의 유효성 검사를 수행한다.")
    void test_create_user_instance() {

        // then
        assertThatThrownBy(
                () ->
                {
                    // when
                    CreateProfile.builder()
                                 .username(null)
                                 .nickname(null)
                                 .build();
                }
        ).isInstanceOf(IllegalArgumentException.class);

        // then
        assertThatThrownBy(
                () -> {
                    // when
                    CreateProfile.builder()
                                 .username(Username.of("", ""))
                                 .nickname("")
                                 .build();
                }
        ).isInstanceOf(IllegalArgumentException.class);


        // then
        assertThatThrownBy(
                () -> {
                    // when
                    new CreateProfile(
                            "admin"
                            , ""
                            , null
                            , "choicore"
                            , Gender.of("MEN")
                            , new BirthDate(1993, 9, 22)
                    );
                }
        ).isInstanceOf(IllegalArgumentException.class);


        // when
        assertThatThrownBy(
                () -> {
                    // when
                    new CreateProfile(
                            "admin"
                            , ""
                            , null
                            , "choicore"
                            , Gender.MALE
                            , new BirthDate(1993, 9, 22)

                    );
                }
        ).isInstanceOf(IllegalArgumentException.class);

        // given & when
        CreateProfile admin = new CreateProfile(
                "admin"
                , "admin"
                , Username.of("재형", "최")
                , "choicore"
                , Gender.MALE
                , new BirthDate(1993, 9, 22)
        );

        assertThat(admin).isNotNull();
    }

}