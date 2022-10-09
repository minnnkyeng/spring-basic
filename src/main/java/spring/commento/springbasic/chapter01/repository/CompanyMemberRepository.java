package spring.commento.springbasic.chapter01.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import spring.commento.springbasic.chapter01.Member;
import spring.commento.springbasic.chapter01.TempClass;

@Slf4j
//@Repository
public class CompanyMemberRepository implements MemberRepository{
    @Override
    public Member findMemberById(Long id) {
        log.info("\n CompanyMemberRepository");
        return TempClass.getInstance().findMember(id);
    }
}
