package com.lalalalz.infra.adapter.out;

import com.lalalalz.application.port.member.in.model.GetMemberResponse;
import com.lalalalz.application.port.member.out.LoadMemberPort;
import com.lalalalz.domain.member.Member;
import com.lalalalz.infra.adapter.out.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoadMemberAdapter implements LoadMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public Optional<String> findEmail(final String email) {
        return memberRepository.findEmail(email);
    }

    @Override
    public Optional<Member> findByEmail(final String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public List<GetMemberResponse> searchMembersByEmail(List<String> emails) {
        return memberRepository.searchMemberByEmail(emails);
    }
}
