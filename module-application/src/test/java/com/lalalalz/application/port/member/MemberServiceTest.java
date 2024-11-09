package com.lalalalz.application.port.member;

import com.lalalalz.application.port.member.in.model.ChangePasswordRequest;
import com.lalalalz.application.port.member.in.model.ChangePasswordResponse;
import com.lalalalz.application.port.member.in.model.CreateMemberRequest;
import com.lalalalz.application.port.member.in.model.CreateMemberResponse;
import com.lalalalz.application.port.member.out.LoadMemberPort;
import com.lalalalz.application.port.member.out.SaveMemberPort;
import com.lalalalz.domain.member.Address;
import com.lalalalz.domain.member.Member;
import com.lalalalz.domain.member.Profile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock LoadMemberPort loadMemberPort;
    @Mock SaveMemberPort saveMemberPort;
    @InjectMocks MemberService memberService;

    static final String email = "test@test.com";
    static final String password = "123412341234";
    static final String username = "test";
    static final boolean isBest = true;
    static final String profileImgUrl = "test.profile.url";
    static final String phone = "123456789";
    static final Address address = new Address("ICN", "test");
    static final Profile profile = new Profile("hello world", "imgurl");

    @Test
    void 회원_추가() {
        // given
        Member newMember = Member.withId(1L, email, username, password, isBest, phone, address, profile);
        CreateMemberRequest createMemberRequest = new CreateMemberRequest(email, username, password, password, "INC", "test");

        when(loadMemberPort.findEmail(email)).thenReturn(Optional.empty());
        when(saveMemberPort.save(any(Member.class))).thenReturn(newMember);

        // when
        CreateMemberResponse createMemberResponse = memberService.createMember(createMemberRequest);

        // then
        assertThat(createMemberResponse).hasFieldOrPropertyWithValue("id", newMember.getId());
    }

    @Test
    void 아이디_중복_회원_추가() {
        // given
        CreateMemberRequest createMemberRequest = new CreateMemberRequest(email, username, password, password, "INC", "test");

        // when
        when(loadMemberPort.findEmail(email)).thenReturn(Optional.of(email));

        // then
        assertThatThrownBy(() -> memberService.createMember(createMemberRequest))
                .isInstanceOf(DuplicatedEmailException.class);
    }

    @Test
    void 비밀번호_변경() {
        // given
        String newPassword = "12345678910e";
        Member member = Member.withoutId(email, username, password, password, address);
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest(email, password, newPassword);

        // when
        when(loadMemberPort.findByEmail(email)).thenReturn(Optional.of(member));
        ChangePasswordResponse changePasswordResponse = memberService.changePassword(changePasswordRequest);

        // then
        assertThat(changePasswordResponse.isChanged()).isTrue();
    }

    @Test
    void 비밀번호_변경_실패_길이() {
        // given
        String newPassword = "1";
        Member member = Member.withoutId(email, username, password, phone, address);
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest(email, password, newPassword);

        // when
        when(loadMemberPort.findByEmail(email)).thenReturn(Optional.of(member));
        ChangePasswordResponse changePasswordResponse = memberService.changePassword(changePasswordRequest);

        // then
        assertThat(changePasswordResponse.isChanged()).isFalse();
        assertThat(changePasswordResponse.getMessage()).isEqualToIgnoringWhitespace("비밀번호 길이가 올바르지 않습니다.");
    }

    @Test
    void 비밀번호_변경_실패_이전_비밀번호와_동일() {
        // given
        Member member = Member.withoutId(email, username, password, phone, address);
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest(email, password, password);

        // when
        when(loadMemberPort.findByEmail(email)).thenReturn(Optional.of(member));
        ChangePasswordResponse changePasswordResponse = memberService.changePassword(changePasswordRequest);

        // then
        assertThat(changePasswordResponse.isChanged()).isFalse();
        assertThat(changePasswordResponse.getMessage()).isEqualToIgnoringWhitespace("동일한 비밀번호로 변경하였습니다.");
    }
}