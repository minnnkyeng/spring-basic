package spring.commento.springbasic.chapter03;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import spring.commento.springbasic.chapter03.domain.Company;
import spring.commento.springbasic.chapter03.domain.User;
import spring.commento.springbasic.chapter03.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Slf4j
@SpringBootTest
@Rollback(value = false)
@Transactional
public class Chapter03Test_02 {
    @PersistenceContext
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void initData(){
        User member1 = new User();
        member1.setName("saechim");
        member1.setAge(28);

        User member = new User();
        member.setName("ChimChakMan");
        member.setAge(40);

        Company company = new Company();
        company.setCompanyName("samsung");
        company.setUsers(List.of(member,member1));

        member.setCompany(company);
        member1.setCompany(company);

        em.persist(company);
        em.flush();
        em.clear();
    }

    @AfterEach
    void fin(){
        List<User> members = em.createQuery("select m from User m",User.class)
                               .getResultList();

        List<Company> companies = em.createQuery("select c from Company c",Company.class)
                                    .getResultList();

        members.forEach(member -> em.detach(member));
        em.clear();
        em.flush();
        companies.forEach(company -> em.detach(company));
        em.clear();
        em.flush();
    }

    @Test
    @DisplayName("n+1 문제")
    void Nplus1Problem(){

        User member = em.find(User.class, 1L);
        log.info(" 회원 이름 =  {}" , member.getName());

        log.info("회원이 소속한 회사 이름 = {}" ,member.getCompany().getCompanyName());
    }


    @Test
    @DisplayName("n+1 문제 fetchjoin 해결")
    void Nplus1Problem_fetchjoin(){
        userRepository.printMemberAndCompanyfetch(1L);
    }

    @Test
    @DisplayName("페이징")
    void paging(){
        for(int i=1; i<=30; i++){
            User member = new User();
            member.setName("회원 " +i);
            member.setAge(i);
            em.persist(member);
        }
        em.flush();
        em.clear();

        List<User> memberByPaging = userRepository.findMemberByPaging(2, 10);
        log.info("\n size = {}" , memberByPaging.size());

        for (User member : memberByPaging) {
            log.info("\n memberName :{}  memberAge : {}",member.getName(), member.getAge());
        }
    }
}
