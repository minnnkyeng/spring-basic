package spring.commento.springbasic.chapter04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.commento.springbasic.chapter04.domain.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductName(String productName);

}
