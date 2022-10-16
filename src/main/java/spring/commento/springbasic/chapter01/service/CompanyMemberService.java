package spring.commento.springbasic.chapter01.service;

import lombok.RequiredArgsConstructor;
import spring.commento.springbasic.global.Member;
import spring.commento.springbasic.chapter01.repository.MemberRepository;

@RequiredArgsConstructor
//@Service
public class CompanyMemberService implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public Member findMemberById(Long id) {
        return memberRepository.findMemberById(id);
    }
}
