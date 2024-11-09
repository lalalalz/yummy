package com.lalalalz.web.join.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JoinRequest {

    private String email;
    private String username;
    private String password;
    private String phone;
    private String city;
    private String roadAddress;
}
