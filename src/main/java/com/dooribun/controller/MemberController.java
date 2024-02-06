package com.dooribun.controller;

import com.dooribun.domain.Member;
import com.dooribun.dto.MemberDTO;
import com.dooribun.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Long> CreateMember(@RequestBody MemberDTO.CreationReq req) {
        return new ResponseEntity<>(memberService.CreateMember(req), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Member> getMembers(){
        return memberService.findAllMembers();
    }
}
