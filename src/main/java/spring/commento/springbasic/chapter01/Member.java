package spring.commento.springbasic.chapter01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@ToString
public class Member {
    private String userName;
    private String pwd;
    private int age;
}
