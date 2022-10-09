package spring.commento.springbasic.chapter01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import spring.commento.springbasic.chapter01.repository.CompanyMemberRepository;
import spring.commento.springbasic.chapter01.repository.MemberRepository;
import spring.commento.springbasic.chapter01.service.CompanyMemberService;

@SpringBootTest
@Slf4j
public class UsingSpringTest {

    @Autowired
    CompanyMemberService companyMemberService;

    @Autowired
    @Qualifier("homeMemberRepository")
    MemberRepository memberRepository;

    @Test
    @DisplayName("빈이 두개 이상")
    void beanType(){
        Member memberById = memberRepository.findMemberById(1L);
        log.info("\n member = {}" ,memberById);
    }


    @Test
    void findById(){
        Member memberById = companyMemberService.findMemberById(1L);
        log.info(memberById.toString());
    }
}
