package spring.commento.springbasic.chapter03.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "users")
@NamedQuery(
    name = "User.findByName",
    query = "select u from User u where u.name = :name"
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY) //매핑 설정
    @JoinColumn(name = "company_id") //외래키 이름
    private Company company;

    public void changeCompany(Company company){
        this.company = company;
        company.getUsers().add(this);
    }
}
