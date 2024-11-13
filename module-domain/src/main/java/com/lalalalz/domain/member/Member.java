package com.lalalalz.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import static com.lalalalz.domain.member.policy.MemberPasswordLengthPolicy.max;
import static com.lalalalz.domain.member.policy.MemberPasswordLengthPolicy.min;
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

    @Column(unique = true)
    private String username;

    @Column(length = max)
    private String password;

    @Column
    private boolean isTaster;

    @Column
    private String phone;

    @Column
    private Address address;

    @Column
    private Profile profile;

    public static Member withoutId(@NonNull final String email,
                                   @NonNull final String username,
                                   @NonNull final String password,
                                   @NonNull final String phone,
                                   @NonNull final Address address
    ) {
        return new Member(null, email, username, password, false, phone, address, new Profile());
    }

    public static Member withId(final long id,
                                @NonNull final String email,
                                @NonNull final String username,
                                @NonNull final String password,
                                final boolean isTaster,
                                @NonNull final String phone,
                                @NonNull final Address address,
                                @NonNull final Profile profile
    ) {
        return new Member(id, email, username, password, isTaster, phone, address, profile);
    }

    public void changePassword(@NonNull final String newPassword) {
        if (!isAppropriateLength(newPassword)) {
            throw new PasswordLengthException();
        }

        if (isSamePasswordTo(newPassword)) {
            throw new SamePasswordException();
        }

        password = newPassword;
    }

    public void promote() {
        isTaster = true;
    }

    public void demote() {
        isTaster = false;
    }

    public void uploadProfile(@NonNull final Profile newProfile) {
        profile = newProfile;
    }

    private static boolean isAppropriateLength(@NonNull final String newPassword) {
        return newPassword.length() >= min && newPassword.length() <= max;
    }

    private boolean isSamePasswordTo(@NonNull final String newPassword) {
        return password.equals(newPassword);
    }
}
