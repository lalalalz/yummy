package com.lalalalz.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import static com.lalalalz.domain.member.MemberPasswordLengthPolicy.max;
import static com.lalalalz.domain.member.MemberPasswordLengthPolicy.min;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(length = max)
    private String password;

    public static Member withoutId(@NonNull final String email,
                                   @NonNull final String password
    ) {
        return new Member(null, email, password);
    }

    public static Member withId(@NonNull final Long id,
                                @NonNull final String email,
                                @NonNull final String password
    ) {
        return new Member(id, email, password);
    }

    public boolean changePassword(@NonNull final String newPassword) {
        if (isAppropriateLength(newPassword) && !isSamePasswordTo(newPassword)) {
            password = newPassword;    
            return true;
        }
        
        return false;
    }

    private static boolean isAppropriateLength(String newPassword) {
        return newPassword.length() >= min && newPassword.length() <= max;
    }

    private boolean isSamePasswordTo(String newPassword) {
        return password.equals(newPassword);
    }
}
