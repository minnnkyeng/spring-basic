package spring.commento.springbasic.chapter01;

import spring.commento.springbasic.chapter01.repository.CompanyMemberRepository;
import spring.commento.springbasic.chapter01.service.CompanyMemberService;

public class NotSpringApplication {
    public static void main(String[] args) {
        CompanyMemberService companyMemberRepository = new CompanyMemberService(new CompanyMemberRepository());
        Member memberById = companyMemberRepository.findMemberById(1l);

        System.out.println(memberById.getUserName());
    }
}
