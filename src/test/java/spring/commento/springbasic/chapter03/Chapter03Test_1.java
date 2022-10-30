package spring.commento.springbasic.chapter03;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
public class Chapter03Test_1 {
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
        company.setUsers(List.of(member, member1));

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
    void mistake(){
        userRepository.mistake();
        List<User> members = em.createQuery("select m from User m",User.class)
                               .getResultList();

        List<Company> companies = em.createQuery("select c from Company c",Company.class)
                                    .getResultList();

        for (User member : members) {
            log.info("\n member name : {} age :{} , member.company {}",member.getName(), member.getAge(),member.getCompany());
        }

        for (Company company : companies) {
            for(User m : company.getUsers()){
                log.info(" companyName : {} , memberName {}", company.getCompanyName(), m.getName());
            }
        }
    }

    @Test
    void correct(){
        userRepository.correct();
        List<User> members = em.createQuery("select m from User m",User.class)
                               .getResultList();

        List<Company> companies = em.createQuery("select c from Company c",Company.class)
                                    .getResultList();

        for (User member : members) {
            log.info("\n member name : {} age :{} , member.company.name {}",member.getName(), member.getAge(),
                     member.getCompany().getCompanyName());
        }

        for (Company company : companies) {
            for(User m : company.getUsers()){
                log.info(" companyName : {} , memberName {}", company.getCompanyName(), m.getName());
            }
        }
    }
}
