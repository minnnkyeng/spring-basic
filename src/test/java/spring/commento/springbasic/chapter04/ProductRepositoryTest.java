package spring.commento.springbasic.chapter04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import spring.commento.springbasic.chapter04.domain.Product;
import spring.commento.springbasic.chapter04.domain.Store;
import spring.commento.springbasic.chapter04.repository.ProductRepository;
import spring.commento.springbasic.chapter04.repository.StoreRepository;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StoreRepository storeRepository;

    @BeforeEach
    void init() {
        Store store1 = new Store("가게1");
        Store store2 = new Store("가게2");

        store1.changeProducts(Arrays.asList(new Product("상품1", 1000, 1000),
                                            new Product("상품2", 2000, 2000)));

        store2.changeProducts(Arrays.asList(new Product("상품1", 3000, 3000),
                                            new Product("상품2", 4000, 4000)));

        storeRepository.saveAll(List.of(store1, store2));
    }

    @Test
    @DisplayName("상품 이름 검색 테스트")
    void findProductByName() {
        List<Product> products = productRepository.findByProductName("상품1");
        Assertions.assertThat(products.size()).isEqualTo(2);
    }

}
