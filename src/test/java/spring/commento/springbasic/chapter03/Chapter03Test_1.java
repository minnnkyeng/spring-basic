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
//@Rollback(value = false)
@Transactional
public class Chapter03Test_1 {
    @PersistenceContext
    EntityManager em;

    @Autowired
    UserRepository userRepository;


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
