package com.lalalalz.application.port.member;

import com.lalalalz.application.port.member.in.ChangePasswordUseCase;
import com.lalalalz.application.port.member.in.CreateMemberUseCase;
import com.lalalalz.application.port.member.in.UploadProfileUseCase;
import com.lalalalz.application.port.member.in.model.*;
import com.lalalalz.application.port.member.out.LoadMemberPort;
import com.lalalalz.application.port.member.out.SaveMemberPort;
import com.lalalalz.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class MemberService implements CreateMemberUseCase, ChangePasswordUseCase, UploadProfileUseCase {

    private final SaveMemberPort saveMemberPort;
    private final LoadMemberPort loadMemberPort;

    @Override @NonNull
    public CreateMemberResponse createMember(@NonNull final CreateMemberRequest createMemberRequest) {
        verifyDuplicatedEmail(createMemberRequest.getEmail());

        Member save = saveMemberPort.save(createMemberRequest.of());

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

        ChangePasswordResponse changePasswordResponse;

        try {
            member.changePassword(changePasswordRequest.getNewPassword());
            changePasswordResponse = new ChangePasswordResponse(true);
        }
        catch (RuntimeException exception) {
            changePasswordResponse = new ChangePasswordResponse(false, exception.getMessage());
        }

        return changePasswordResponse;
    }

    @Override
    public UploadProfileResponse uploadProfile(@NonNull final UploadProfileRequest uploadProfileRequest) {
        return null;
    }
}
