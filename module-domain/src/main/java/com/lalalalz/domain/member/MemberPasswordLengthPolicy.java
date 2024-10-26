package com.lalalalz.domain.member;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class MemberPasswordLengthPolicy {

    public static final int min = 10;
    public static final int max = 20;

}
