package com.lalalalz.infra.adapter.out.persistence;

import com.lalalalz.application.port.member.in.model.GetBestMemberResponse;
import com.lalalalz.application.port.member.in.model.GetMemberResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.lalalalz.domain.member.QMember.member;

@Repository
@RequiredArgsConstructor
class MemberQueryDslRepositoryImpl implements com.lalalalz.infra.adapter.out.persistence.MemberQueryDslRepository {

    private final JPAQueryFactory factory;

    public Optional<String> findEmail(final String email) {
        return Optional.ofNullable(factory.select(member.email)
                .from(member)
                .where(member.email.eq(email))
                .fetchOne());
    }

    @Override
    public List<GetMemberResponse> searchMemberByEmail(List<String> emails) {
        return factory.select(Projections.fields(GetMemberResponse.class,
                        member.email,
                        member.username,
                        member.password,
                        member.isTaster))
                .from(member)
                .where(member.email.in(emails))
                .fetch();
    }

    @Override
    public List<GetBestMemberResponse> findBestMembers(Long count) {
        return factory.select(Projections.fields(GetBestMemberResponse.class,
                        member.email,
                        member.username,
                        member.isTaster))
                .from(member)
                .where(member.isTaster.isTrue())
                .limit(count)
                .fetch();
    }
}
