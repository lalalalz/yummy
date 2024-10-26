package com.lalalalz.application.member;

import com.lalalalz.domain.member.ChangePasswordToSamePasswordException;
import com.lalalalz.domain.member.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    @Test
    void 멤버_생성() {
        // given
        String email = "test@test.com";
        String password = "1234";

        // when
        Member member = Member.withoutId(email, password);

        // then
        assertThat(member)
                .hasFieldOrPropertyWithValue("email", email)
                .hasFieldOrPropertyWithValue("password", password);
    }

    @Test
    void 비밀번호_변경() {
        // given
        String email = "test@test.com";
        String password = "1234";
        Member member = Member.withoutId(email, password);

        // when
        String newPassword = "newPassword";
        member.changePassword(newPassword);

        // then
        assertThat(member).hasFieldOrPropertyWithValue("password", newPassword);
    }

    @Test
    void 동일한_비밀번호로_변경() {
        // given
        String email = "test@test.com";
        String password = "1234";
        Member member = Member.withoutId(email, password);

        // when, then
        assertThatThrownBy(() -> member.changePassword(password))
                .isInstanceOf(ChangePasswordToSamePasswordException.class);
    }
}