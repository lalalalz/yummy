package com.lalalalz.domain.restaurant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Entity @Getter
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class Restaurant {

    @Id @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;
    private String name;
    private String phone;
    private Address address;
    private boolean isOpen;

    public static Restaurant withoutId(final String name,
                                       final String phone,
                                       final Address address
    ) {
        return new Restaurant(null, name, phone, address, true);
    }
}
