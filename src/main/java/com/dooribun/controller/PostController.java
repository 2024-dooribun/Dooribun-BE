package com.dooribun.controller;

import com.dooribun.domain.Post;
import com.dooribun.dto.PostDTO;
import com.dooribun.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Long> createPost(@RequestBody PostDTO.CreationReq req) {
        return new ResponseEntity<>(postService.CreatePost(req), HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO.DetailInfoRes> getPostDetail(@PathVariable("postId") Long postId) {
        return ResponseEntity.ok(postService.getPostDetail(postId));
    }
}
