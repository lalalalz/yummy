package com.lalalalz.application.port.member.in.model;

import com.lalalalz.domain.member.Profile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UploadProfileRequest {

    @NotBlank @Email
    private String email;
    @NotBlank @Size(max = 200)
    private String introduction;
    @NotBlank // TODO : @Pattern 애너테이션으로 URL 패턴 인증 추가
    private String profileImage;

    public Profile of() {
        return new Profile(introduction, profileImage);
    }
}
