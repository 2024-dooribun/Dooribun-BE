package com.dooribun.domain;

import com.dooribun.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uid;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Setter
    @Column(nullable = false)
    private String email;

    @Builder
    public Member(String uid, String password, String nickname, String email) {
        this.uid = uid;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public static Member of(MemberDTO.CreationReq req) {
        return Member.builder()
                .uid(req.getUid())
                .password(req.getPassword())
                .nickname(req.getNickname())
                .email(req.getEmail())
                .build();
    }
}
