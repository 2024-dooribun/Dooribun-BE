package com.dooribun.service;

import com.dooribun.domain.Member;
import com.dooribun.dto.MemberDTO;
import com.dooribun.repository.LocationRepository;
import com.dooribun.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service

public class MemberService {
    private final MemberRepository memberRepository;

    public Long CreateMember(MemberDTO.CreationReq req) {
        Member member = memberRepository.saveAndFlush(Member.of(req));
        return member.getId();
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
}
