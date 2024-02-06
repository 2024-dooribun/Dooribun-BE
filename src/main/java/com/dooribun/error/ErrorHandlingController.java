package com.dooribun.error;

import com.dooribun.exception.LocationNotFoundException;
import com.dooribun.exception.PostNotFoundException;
import com.dooribun.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.dooribun.util.ErrorBuildFactory.buildError;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleMemberNotFoundException() {
        log.error("존재하지 않는 유저 id 입니다.");
        return buildError(ErrorCode.USER_NOT_FOUND);
    }

    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleLocationNotFoundException() {
        log.error("존재하지 않는 지역 id 입니다.");
        return buildError(ErrorCode.LOCATION_NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handlePostNotFoundException() {
        log.error("존재하지 않는 게시글 id 입니다.");
        return buildError(ErrorCode.POST_NOT_FOUND);
    }
}
