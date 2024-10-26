package com.lalalalz.application.port.member;

import com.lalalalz.application.port.member.in.ChangePasswordUseCase;
import com.lalalalz.application.port.member.in.CreateMemberUseCase;
import com.lalalalz.application.port.member.in.model.ChangePasswordRequest;
import com.lalalalz.application.port.member.in.model.ChangePasswordResponse;
import com.lalalalz.application.port.member.in.model.CreateMemberRequest;
import com.lalalalz.application.port.member.in.model.CreateMemberResponse;
import com.lalalalz.application.port.member.out.LoadMemberPort;
import com.lalalalz.application.port.member.out.SaveMemberPort;
import com.lalalalz.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class MemberService implements CreateMemberUseCase, ChangePasswordUseCase {

    private final SaveMemberPort saveMemberPort;
    private final LoadMemberPort loadMemberPort;

    @Override @NonNull
    public CreateMemberResponse createMember(@NonNull final CreateMemberRequest createMemberRequest) {
        verifyDuplicatedEmail(createMemberRequest.getEmail());

        Member save = saveMemberPort.save(Member.withoutId(
                        createMemberRequest.getEmail(),
                        createMemberRequest.getPassword()));

        return CreateMemberResponse.from(save);
    }

    private void verifyDuplicatedEmail(@NonNull final String email) {
        if (loadMemberPort.findEmail(email).isPresent()) {
            throw new DuplicatedEmailException();
        }
    }

    @Override @NonNull
    public ChangePasswordResponse changePassword(@NonNull final ChangePasswordRequest changePasswordRequest) {
        Member member = loadMemberPort
                .findByEmail(changePasswordRequest.getEmail())
                .orElseThrow(InvalidEmailException::new);

        boolean changeRequestResult =
                member.changePassword(changePasswordRequest.getNewPassword());

        if (changeRequestResult) {
            saveMemberPort.save(member);
        }

        return new ChangePasswordResponse(changeRequestResult);
    }
}
