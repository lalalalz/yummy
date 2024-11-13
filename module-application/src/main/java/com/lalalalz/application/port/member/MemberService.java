package com.lalalalz.application.port.member;

import com.lalalalz.application.port.member.in.ChangePasswordUseCase;
import com.lalalalz.application.port.member.in.CreateMemberUseCase;
import com.lalalalz.application.port.member.in.UploadProfileUseCase;
import com.lalalalz.application.port.member.in.model.ChangePasswordRequest;
import com.lalalalz.application.port.member.in.model.CreateMemberRequest;
import com.lalalalz.application.port.member.in.model.CreateMemberResponse;
import com.lalalalz.application.port.member.in.model.UploadProfileRequest;
import com.lalalalz.application.port.member.out.LoadMemberPort;
import com.lalalalz.application.port.member.out.SaveMemberPort;
import com.lalalalz.domain.member.DomainException;
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

        Member member = saveMemberPort.save(createMemberRequest.of());

        return CreateMemberResponse.from(member);
    }

    private void verifyDuplicatedEmail(@NonNull final String email) {
        if (loadMemberPort.findEmail(email).isPresent()) {
            throw new DuplicatedEmailException();
        }
    }

    @Override @NonNull
    public void changePassword(@NonNull final ChangePasswordRequest changePasswordRequest) {
        Member member = loadMemberPort
                .findByEmail(changePasswordRequest.getEmail())
                .orElseThrow(InvalidEmailException::new);

        member.changePassword(changePasswordRequest.getNewPassword());
    }

    @Override @NonNull
    public void uploadProfile(@NonNull final UploadProfileRequest uploadProfileRequest) {
        Member member = loadMemberPort
                .findByEmail(uploadProfileRequest.getEmail())
                .orElseThrow(InvalidEmailException::new);

        try {
            member.uploadProfile(uploadProfileRequest.of());
        }
        catch (DomainException domainException) {
            throw new UploadProfileException(domainException.getMessage());
        }
    }
}
