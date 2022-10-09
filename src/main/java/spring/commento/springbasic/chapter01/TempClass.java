package spring.commento.springbasic.chapter01;

import java.util.HashMap;
import java.util.Map;

// 간단한 실습을 위한 클래스
public class TempClass {

    private static TempClass INSTANCE = new TempClass();

    private TempClass(){}

    private static final Map<Long,Member> memberMap = Map.of(
        1L,new Member("commento","1234",30),
        2L,new Member("spring","4567",20)
    );

    public static TempClass getInstance(){
        return INSTANCE;
    }

    public Member findMember(Long id){
        return memberMap.getOrDefault(id, new Member());
    }
}
