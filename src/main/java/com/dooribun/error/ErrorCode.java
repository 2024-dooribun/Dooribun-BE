package com.dooribun.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_NOT_FOUND("USER_NOT_FOUND", "해당 유저를 찾을 수 없습니다.", 400),
    LOCATION_NOT_FOUND("LOCATION_NOT_FOUND", "해당 지역을 찾을 수 없습니다.", 400),
    POST_NOT_FOUND("POST_NOT_FOUND", "해당 게시글을 찾을 수 없습니다.", 400),
    ;

    private final String code;
    private final String message;
    private final Integer status;

    ErrorCode(String code, String message, Integer status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
