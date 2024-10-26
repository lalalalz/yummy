package com.lalalalz.application.port.member;

import com.lalalalz.application.port.member.in.model.ChangePasswordRequest;
import com.lalalalz.application.port.member.in.model.ChangePasswordResponse;
import com.lalalalz.application.port.member.in.model.CreateMemberRequest;
import com.lalalalz.application.port.member.in.model.CreateMemberResponse;
import com.lalalalz.application.port.member.out.LoadMemberPort;
import com.lalalalz.application.port.member.out.SaveMemberPort;
import com.lalalalz.domain.member.Member;
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
    static final String password = "1234";

    @Test
    void 회원_추가() {
        // given
        Member newMember = Member.withId(1L, email, password);
        CreateMemberRequest createMemberRequest = new CreateMemberRequest(email, password);

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
        CreateMemberRequest createMemberRequest = new CreateMemberRequest(email, password);

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
        Member member = Member.withoutId(email, password);
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest(email, password, newPassword);

        // when
        when(loadMemberPort.findByEmail(email)).thenReturn(Optional.of(member));
        ChangePasswordResponse changePasswordResponse = memberService.changePassword(changePasswordRequest);

        // then
        assertThat(changePasswordResponse.isChanged()).isTrue();
    }
}