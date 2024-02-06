package com.dooribun.exception;

import lombok.Getter;

import java.security.Principal;

@Getter
public class PostNotFoundException extends RuntimeException{
    private final Object postId;
    private Principal principal;

    public PostNotFoundException(Object postId) { this.postId = postId; }

    public PostNotFoundException(Object postId, Principal principal) {
        this.postId = postId;
        this.principal = principal;
    }
}
