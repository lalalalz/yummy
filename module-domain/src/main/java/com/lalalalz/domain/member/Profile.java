package com.lalalalz.domain.member;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import static lombok.AccessLevel.PROTECTED;

@Embeddable
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Profile {

    private String introduction;
    private String profileImage;

    public Profile(@Nullable final String newIntroduction, @NonNull final String newProfileImage) {
        if (!StringUtils.hasText(newProfileImage)) {
            throw new InvalidProfileImageUrlException();
        }

        profileImage = newProfileImage;
        introduction = newIntroduction;
    }
}
