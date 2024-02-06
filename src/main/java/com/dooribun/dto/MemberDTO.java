package com.dooribun.dto;

import lombok.*;

public class MemberDTO {
    @Getter @Setter
    @ToString @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreationReq{
        private String uid;
        private String password;
        private String nickname;
        private String email;
    }
}
