package com.lalalalz.application.port.member;

import com.lalalalz.application.port.member.in.SearchMemberUseCase;
import com.lalalalz.application.port.member.in.model.*;
import com.lalalalz.application.port.member.out.LoadMemberPort;
import com.lalalalz.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSearch implements SearchMemberUseCase {

    private final LoadMemberPort loadMemberPort;

    @Override @NonNull
    public GetMemberResponse getMember(@NonNull final GetMemberRequest getMemberRequest) {
        Member member = loadMemberPort
                .findByEmail(getMemberRequest.getEmail())
                .orElseThrow(InvalidEmailException::new);

        return GetMemberResponse.from(member);
    }

    @Override @NonNull
    public GetMembersResponse getMembers(@NonNull final GetMembersRequest getMembersRequest) {
        return new GetMembersResponse(loadMemberPort.searchMembersByEmail(getMembersRequest.getEmails()));
    }

    @Override @NonNull
    public GetTasterMembersResponse getTasterMembers(@NonNull final GetTasterMembersRequest getTasterMembersRequest) {
        return new GetTasterMembersResponse(loadMemberPort.findTasterMembers(getTasterMembersRequest.getCount()));
    }
}
