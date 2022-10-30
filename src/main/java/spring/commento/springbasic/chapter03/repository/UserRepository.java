package spring.commento.springbasic.chapter03.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import spring.commento.springbasic.chapter03.domain.Company;
import spring.commento.springbasic.chapter03.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Slf4j
@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void mistake(){

        User member = new User();
        member.setName("saechim");
        em.persist(member);

        Company company= new Company();
        company.setCompanyName("commento");

        // 역방향(주인이 아닌 방향)만 연관관계 설정
        company.getUsers().add(member);

        em.persist(company);

    }

    public void correct(){

        User member = new User();
        member.setName("saechim");
        em.persist(member);

        Company company= new Company();
        company.setCompanyName("commento");


        company.getUsers().add(member);

        //연관관계의 주인에 값 설정
        member.changeCompany(company);

        em.persist(company);

    }

    public void printMemberAndCompany(Long memberId){
        User member = em.find(User.class, memberId);
        log.info(" 회원 이름 =  {}" , member.getName());

        log.info("회원이 소속한 회사 이름 = {}" ,member.getCompany().getCompanyName());
    }

    public void printMemberAndCompanyfetch(Long id){
        User member1 = em.createQuery("select m from User m join fetch m.company where m.id = :id", User.class)
            .setParameter("id",id)
                         .getSingleResult();

        log.info(" 회원 이름 =  {}" , member1.getName());

        log.info("회원이 소속한 회사 이름 = {}" ,member1.getCompany().getCompanyName());
    }


    public void printOnlyMember(Long memberId){
        User member = em.find(User.class, memberId);
        Company company = member.getCompany();

        log.info(" 회원 이름 =  {}" , member.getName());

    }

    public void cascade(){
        User member = new User();
        member.setName("saechim");

        Company company = new Company();
        company.setCompanyName("COMMENTO");

        member.setCompany(company);

        em.persist(member);

    }

    public List<User> findByNameAndAgeGraterThan(String name, int age){
        return em.createQuery("select m from Member m where m.name = :name and m.age > : age")
                 .setParameter("name",name)
                 .setParameter("age",age)
                 .getResultList();
    }

    public List<User> findByName(String name) {
        return em.createNamedQuery("User.findByName", User.class)
                 .setParameter("name",name)
                 .getResultList();
    }

    public List<User> findMemberByPaging(int offset, int limit) {
        return em.createQuery("select m from User m order by m.age asc", User.class)
                 .setFirstResult(offset) //offset째 부터
                 .setMaxResults(limit)
                 .getResultList();
    }
}
