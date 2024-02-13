package com.dooribun.dto;

import com.dooribun.domain.Image;
import com.dooribun.domain.Member;
import com.dooribun.domain.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PostDTO {
    @Getter @Setter
    @ToString @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreationReq{
        private String title;
        private String content;
        private Long memberId;
    }

    @Getter @Setter @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostDetailRes {
        private PostInfo postInfo;
        private MemberInfo memberInfo;

        public static PostDetailRes of(Post post) {
            Member member = post.getMember();
            List<String> images = post.getImages()
                    .stream()
                    .map(Image::getFilePath)
                    .collect(Collectors.toList());

            return PostDetailRes.builder()
                    .memberInfo(MemberInfo.of(member))
                    .postInfo(PostInfo.of(post, images))
                    .build();
        }
    }

    @Getter @Builder
    @AllArgsConstructor
    public static class PostInfo{
        private Long id;
        private String title;
        private String content;
        private Boolean status;
        private LocalDateTime createdAt;
        private List<String> imagePaths;

        private static PostInfo of(Post post, List<String> imagePaths) {
            return PostInfo.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .status(post.getStatus())
                    .createdAt(post.getCreatedAt())
                    .imagePaths(imagePaths)
                    .build();
        }
    }

    @Builder @Getter
    @AllArgsConstructor
    public static class MemberInfo {
        private Long id;
        private String nickname;

        public static MemberInfo of(Member member) {
            return MemberInfo.builder()
                    .id(member.getId())
                    .nickname(member.getNickname())
                    .build();
        }
    }

}
