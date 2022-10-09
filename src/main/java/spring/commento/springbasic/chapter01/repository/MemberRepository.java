package spring.commento.springbasic.chapter01.repository;

import spring.commento.springbasic.chapter01.Member;

public interface MemberRepository {

    Member findMemberById(Long id);

}
