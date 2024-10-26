package com.lalalalz.application.api;

import com.lalalalz.application.member.adapter.out.persistence.MemberRepository;
import com.lalalalz.application.member.application.port.in.SearchMemberUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestServiceTest {

    @Autowired
    SearchMemberUseCase searchMemberUseCase;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TestService testService;

    @Test
    void test() {
//        searchMemberUseCase.isValidMemberEmail("lalalalz");
////        memberRepository.hasAlreadyEmail("lalalalz");

        testService.test();
    }

}