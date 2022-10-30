package spring.commento.springbasic.chapter04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.commento.springbasic.chapter04.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
