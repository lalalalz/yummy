package com.lalalalz.application.member;

import com.lalalalz.domain.member.Address;
import com.lalalalz.domain.member.Member;
import com.lalalalz.domain.member.Profile;
import com.lalalalz.domain.member.SamePasswordException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    final static String email = "test@test.com";
    final static String username = "test";
    final static String phone = "01077133697";
    final static String password = "123412341234";
    final static Address address = new Address("INC", "인항로 30");
    final static Profile profile = new Profile("hello", "http://profile.test");

    @Test
    void 멤버_생성() {
        // given, when
        Member member = Member.withoutId(email, username, password, phone, address);

        // then
        assertThat(member)
                .hasFieldOrPropertyWithValue("email", email)
                .hasFieldOrPropertyWithValue("password", password);
    }

    @Test
    void 비밀번호_변경() {
        // given
        Member member = Member.withoutId(email, username, password, phone, address);

        // when
        String newPassword = "newPassword";
        member.changePassword(newPassword);

        // then
        assertThat(member).hasFieldOrPropertyWithValue("password", newPassword);
    }

    @Test
    void 동일한_비밀번호로_변경() {
        // given
        Member member = Member.withoutId(email, username, password, phone, address);

        // when, then
        assertThatThrownBy(() -> member.changePassword(password))
                .isInstanceOf(SamePasswordException.class);
    }

    @Test
    void 맛잘러로_승급하다() {
        // given
        String email = "test@test.com";
        String username = "test";
        String password = "1234";
        String profileImgUrl = "test.url";
        Member member = Member.withId(1L, email, username, password, false, phone, address, profile);

        // when
        member.promote();

        // then
        assertThat(member.isTaster()).isTrue();
    }

    @Test
    void 맛잘러에서_강등되다() {
        // given
        Member member = Member.withId(1L, email, username, password, true, phone, address, profile);

        // when
        member.demote();

        // then
        assertThat(member.isTaster()).isFalse();
    }

    @Test
    void 프로필_이미지_업로드() {
        // given
        Member member = Member.withoutId(email, username, password, phone, address);
        Profile profile = new Profile("hello world", "http://profile.test");

        // when
        member.uploadProfile(profile);

        // then
        assertThat(member.getProfile().getIntroduction()).isEqualTo(profile.getIntroduction());
        assertThat(member.getProfile().getProfileImage()).isEqualTo(profile.getProfileImage());
    }
}