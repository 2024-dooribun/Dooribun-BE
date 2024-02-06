package com.dooribun.service;

import com.dooribun.domain.Location;
import com.dooribun.domain.Member;
import com.dooribun.domain.Post;
import com.dooribun.dto.PostDTO;
import com.dooribun.exception.LocationNotFoundException;
import com.dooribun.exception.PostNotFoundException;
import com.dooribun.exception.UserNotFoundException;
import com.dooribun.repository.LocationRepository;
import com.dooribun.repository.MemberRepository;
import com.dooribun.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PostService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public Long CreatePost(PostDTO.CreationReq req) {
        Long memberId = req.getMemberId();
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new UserNotFoundException(memberId));
        Post post = postRepository.saveAndFlush(Post.of(req, member));

        return post.getId();
    }

    @Transactional(readOnly = true)
    public PostDTO.DetailInfoRes getPostDetail(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
        return PostDTO.DetailInfoRes.of(post);
    }
}