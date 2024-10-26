package com.lalalalz.api.member;

import com.lalalalz.application.port.member.in.ChangePasswordUseCase;
import com.lalalalz.application.port.member.in.CreateMemberUseCase;
import com.lalalalz.application.port.member.in.SearchMemberUseCase;
import com.lalalalz.application.port.member.in.model.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final CreateMemberUseCase createMemberUseCase;
    private final ChangePasswordUseCase changePasswordUseCase;
    private final SearchMemberUseCase searchMemberUseCase;

    @GetMapping("/member/{email}")
    public ResponseEntity<GetMemberResponse> getMember(
            @ModelAttribute @Valid final GetMemberRequest getMemberRequest
    ) {
        return ResponseEntity.ok(searchMemberUseCase.getMember(getMemberRequest));
    }

    @PostMapping("/members")
    public ResponseEntity<GetMembersResponse> getMembers(
            @RequestBody @Valid final GetMembersRequest getMembersRequest
    ) {
        return ResponseEntity.ok(searchMemberUseCase.getMembers(getMembersRequest));
    }

    @PostMapping("/member")
    public ResponseEntity<CreateMemberResponse> createMember(
            @RequestBody @Valid final CreateMemberRequest createMemberRequest
    ) {
        return ResponseEntity.ok(createMemberUseCase.createMember(createMemberRequest));
    }

    @PostMapping("/member/change-password")
    public ResponseEntity<ChangePasswordResponse> changePassword(
            @RequestBody @Valid final ChangePasswordRequest changePasswordRequest
    ) {
        return ResponseEntity.ok(changePasswordUseCase.changePassword(changePasswordRequest));
    }
}
