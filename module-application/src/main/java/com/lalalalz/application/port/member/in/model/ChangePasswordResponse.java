package com.lalalalz.application.port.member.in.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordResponse {

    private boolean isChanged;
    private String message;

    public ChangePasswordResponse(boolean isChanged) {
        this.isChanged = isChanged;
    }
}
