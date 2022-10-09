package spring.commento.springbasic.chapter01.repository;

import lombok.extern.slf4j.Slf4j;
import spring.commento.springbasic.chapter01.Member;
import spring.commento.springbasic.chapter01.TempClass;

@Slf4j
//@Repository
public class HomeMemberRepository implements MemberRepository {
    @Override
    public Member findMemberById(Long id) {
        log.info("\n homeMemberRepository");
        return TempClass.getInstance().findMember(id);
    }
}
