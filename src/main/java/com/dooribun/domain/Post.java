package com.dooribun.domain;

import com.dooribun.dto.PostDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Boolean status;


    @ManyToOne @Setter
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Image> images = new ArrayList<>();

    @Builder
    public Post(String title, String content, LocalDateTime createdAt, Boolean status, Member member) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.status = status;
        this.member = member;
    }

    public static Post of(PostDTO.CreationReq req, Member member) {
        return Post.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .createdAt(LocalDateTime.now())
                .status(Boolean.TRUE)
                .member(member)
                .build();
    }
}
