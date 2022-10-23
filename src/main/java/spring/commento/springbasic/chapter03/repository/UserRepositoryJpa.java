package spring.commento.springbasic.chapter03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.commento.springbasic.chapter03.domain.User;
import spring.commento.springbasic.chapter03.dto.MemberDto;

import java.util.List;

public interface UserRepositoryJpa extends JpaRepository<User, Long> {

    List<User> findByNameAndAgeGreaterThan(String name, int age);

    @Query(name = "Member.findByName")
    List<User> findByName(@Param("username") String name);

    @Query("select m from User m where m.name = :name and m.age = :age")
    List<User> findMember(@Param("name") String name, @Param("age") int age);

    // 단순히 값 하나를 조회
    @Query("select m.name from User m")
    List<String> findUNameList();

    // DTO로 직접 조회
    @Query("select new spring.commento.springbasic.chapter03.dto.MemberDto(m.name,c.companyName)" +
        "from User m join m.company c")
    List<MemberDto> findMemberDto();

    @Query("select m from User m where m.name in :names")
    List<User> findByNames(@Param("names") List<String> names);

}




