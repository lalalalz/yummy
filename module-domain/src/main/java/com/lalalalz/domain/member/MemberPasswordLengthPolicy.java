package com.lalalalz.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberPasswordLengthPolicy {

    min(10),
    max(20)
    ;

    private final int length;
}
