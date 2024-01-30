package com.dooribun.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String file_name;

    @Column(nullable = false)
    private String file_path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Builder
    public Image(String file_name, String file_path, Post post) {
        this.file_name = file_name;
        this.file_path = file_path;
        this.post = post;
    }
}
