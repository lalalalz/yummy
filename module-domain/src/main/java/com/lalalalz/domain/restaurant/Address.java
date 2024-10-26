package com.lalalalz.domain.restaurant;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable @Getter
@AllArgsConstructor
public class Address {

    private String zipcode;
}
