package spring.commento.springbasic.chapter01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring.commento.springbasic.chapter01.repository.CompanyMemberRepository;
import spring.commento.springbasic.chapter01.repository.HomeMemberRepository;
import spring.commento.springbasic.chapter01.repository.MemberRepository;
import spring.commento.springbasic.chapter01.service.CompanyMemberService;
import spring.commento.springbasic.chapter01.service.MemberService;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public MemberRepository companyMemberRepository(){
        return new CompanyMemberRepository();
    }

    @Bean
    public MemberRepository homeMemberRepository(){
        return new HomeMemberRepository();
    }

    @Bean
    public MemberService companyMemberService(){
        return new CompanyMemberService(companyMemberRepository());
    }

}
