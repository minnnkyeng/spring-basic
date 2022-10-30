package spring.commento.springbasic.chapter04;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.commento.springbasic.chapter04.domain.Product;
import spring.commento.springbasic.chapter04.domain.Store;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Transactional
@Slf4j
public class ProductTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("엔티티매니저로 엔티티가 정상적으로 동작하는지 테스트")
    void testProductEntity1() {
        Store store1 = new Store("가게1");
        Store store2 = new Store("가게2");

        store1.changeProducts(Arrays.asList(new Product("상품1", 1000, 1000),
                                            new Product("상품2", 2000, 2000)));

        store2.changeProducts(Arrays.asList(new Product("상품1", 3000, 3000),
                                            new Product("상품2", 4000, 4000)));

        em.persist(store1);
        em.persist(store2);

        //초기화
        em.flush();
        em.clear();

        List<Product> products = em.createQuery("select p from Product p", Product.class).getResultList();

        products.forEach(product -> {
            log.info("\n product.Name = {}", product.getProductName());
            // 현재 프록시로 가져오니 product의 store안의 필드에 접근할 때 쿼리가 나감
            log.info("\n product.Store = {} ", product.getStore().getStoreName());
        });

    }

    @Test
    @DisplayName("jpql비교 위한 ")
    void jpqlTesting() {
        Store store1 = new Store("가게1");
        Store store2 = new Store("가게2");

        store1.changeProducts(Arrays.asList(new Product("상품1", 1000, 1000),
                                            new Product("상품2", 2000, 2000)));

        store2.changeProducts(Arrays.asList(new Product("상품1", 3000, 3000),
                                            new Product("상품2", 4000, 4000)));

        em.persist(store1);
        em.persist(store2);

        //초기화
        em.flush();
        em.clear();

        List<Product> products = em.createQuery("select p from Product p where p.productName = :productName",
                                                Product.class)
                                   .setParameter("productName", "상품1")
                                   .getResultList();

        for (Product product : products) {
            log.info("\n product.name = {}", product.getProductName());
        }
    }

}
