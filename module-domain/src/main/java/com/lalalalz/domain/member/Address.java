package com.lalalalz.domain.member;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Embeddable @Getter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class Address {

    private String city;
    private String roadAddress;
}
