package com.lalalalz.infra.adapter.out;

import com.lalalalz.application.port.member.out.SaveMemberPort;
import com.lalalalz.domain.member.Member;
import com.lalalalz.infra.adapter.out.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveMemberAdapter implements SaveMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public Member save(final Member member) {
        return memberRepository.save(member);
    }
}
