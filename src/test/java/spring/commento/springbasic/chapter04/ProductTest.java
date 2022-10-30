package spring.commento.springbasic.chapter04;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.commento.springbasic.chapter04.domain.Product;
import spring.commento.springbasic.chapter04.domain.QProduct;
import spring.commento.springbasic.chapter04.domain.QStore;
import spring.commento.springbasic.chapter04.domain.Store;
import spring.commento.springbasic.chapter04.dto.ProductDto;
import spring.commento.springbasic.chapter04.dto.QProductDto;

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

    @Test
    @DisplayName("querydsl 맛보기")
    void querydslTesting() {
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

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Product> product = queryFactory.select(QProduct.product)
                                            .from(QProduct.product)
                                            .where(QProduct.product.productName.eq("상품1"))
                                            .fetch();

        for (Product product1 : product) {
            log.info("\n 이름 {} ", product1.getProductName());
        }
    }

    @Test
    @DisplayName("querydsl 기본 검색 쿼리")
    void querydslTesting2() {
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

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Product> products = queryFactory.select(QProduct.product)
                                             .from(QProduct.product)
                                             .where(QProduct.product.productName.eq("상품1")
                                                                                .and(QProduct.product.price.lt(2000)))
                                             .fetch();

        for (Product product : products) {
            log.info("\n Name = {} price = {} , quantity = {}", product.getProductName(), product.getPrice(), product.getQuantity());

        }

    }

    @Test
    @DisplayName("AND 조건을 파라미터로 처리")
    void querydslTesting3() {
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

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        Product product = queryFactory.select(QProduct.product)
                                      .from(QProduct.product)
                                      .where(QProduct.product.productName.eq("상품1")
                                          , (QProduct.product.price.lt(2000)))
                                      .fetchOne();

        log.info("\n Name = {} price = {} , quantity = {}", product.getProductName(), product.getPrice(), product.getQuantity());

    }

    @Test
    @DisplayName("정렬")
    void querydslTesting4() {
        Store store1 = new Store("가게1");
        Store store2 = new Store("가게2");
        store1.changeProducts(Arrays.asList(new Product("상품1", 1000, 1000),
                                            new Product("상품2", 2000, 2000)));
        store2.changeProducts(Arrays.asList(new Product("상품1", 3000, 3000),
                                            new Product("상품2", 4000, 4000)));

        em.persist(store1);
        em.persist(store2);

        Product product1 = new Product(3000, 4000);
        em.persist(product1);

        //초기화
        em.flush();
        em.clear();

        /*
         * * 1. 상품 가격 내림차순(desc)
         * * 2. 상품 이름 올림차순(asc)
         * * 단 2에서 상품 이름이 없으면 마지막에 출력(nulls last)
         */

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Product> products = queryFactory.select(QProduct.product)
                                             .from(QProduct.product)
                                             .where(QProduct.product.price.lt(4000))
                                             .orderBy(QProduct.product.price.desc(), QProduct.product.productName.asc().nullsLast())
                                             .fetch();

        products.forEach(product -> log.info("\n Name = {} price = {} , quantity = {}",
                                             product.getProductName(),
                                             product.getPrice(),
                                             product.getQuantity()));
    }

    @Test
    @DisplayName("페이징")
    void querydslTesting5() {
        Store store1 = new Store("가게1");
        Store store2 = new Store("가게2");
        store1.changeProducts(Arrays.asList(new Product("상품1", 1000, 1000),
                                            new Product("상품2", 2000, 2000)));
        store2.changeProducts(Arrays.asList(new Product("상품1", 3000, 3000),
                                            new Product("상품2", 4000, 4000)));

        em.persist(store1);
        em.persist(store2);

        Product product1 = new Product(3000, 4000);
        em.persist(product1);

        //초기화
        em.flush();
        em.clear();

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Product> products = queryFactory.selectFrom(QProduct.product)
                                             .orderBy(QProduct.product.quantity.desc())
                                             .offset(1)
                                             .limit(3) // 최대 3건
                                             .fetch();

        products.forEach(product -> log.info("\n name: {} , price: {} , quantity: {} ",
                                             product.getProductName(),
                                             product.getPrice(),
                                             product.getQuantity()));
    }

    @Test
    @DisplayName("집합 함수")
    void querydslTesting6() {
        Store store1 = new Store("가게1");
        Store store2 = new Store("가게2");
        store1.changeProducts(Arrays.asList(new Product("상품1", 1000, 1000),
                                            new Product("상품2", 2000, 2000)));
        store2.changeProducts(Arrays.asList(new Product("상품1", 3000, 3000),
                                            new Product("상품2", 4000, 4000)));

        em.persist(store1);
        em.persist(store2);

        Product product1 = new Product(3000, 4000);
        em.persist(product1);

        //초기화
        em.flush();
        em.clear();

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> tuples = queryFactory.select(QProduct.product.count(),
                                                 QProduct.product.price.sum(),
                                                 QProduct.product.price.avg(),
                                                 QProduct.product.price.max(),
                                                 QProduct.product.price.min())
                                         .from(QProduct.product)
                                         .fetch();
        Tuple tuple = tuples.get(0);
        log.info("\n count = {} , sum = {} , avg = {}, max = {}, min = {}",
                 tuple.get(QProduct.product.count()),
                 tuple.get(QProduct.product.price.sum()),
                 tuple.get(QProduct.product.price.avg()),
                 tuple.get(QProduct.product.price.max()),
                 tuple.get(QProduct.product.price.min()));
    }

    @Test
    @DisplayName("조인")
    void querydslTesting7() {
        Store store1 = new Store("가게1");
        Store store2 = new Store("가게2");
        store1.changeProducts(Arrays.asList(new Product("상품1", 1000, 1000),
                                            new Product("상품2", 2000, 2000)));
        store2.changeProducts(Arrays.asList(new Product("상품1", 3000, 3000),
                                            new Product("상품2", 4000, 4000)));

        em.persist(store1);
        em.persist(store2);

        Product product1 = new Product(3000, 4000);
        em.persist(product1);

        //초기화
        em.flush();
        em.clear();

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Product> products = queryFactory.selectFrom(QProduct.product)
                                             .join(QProduct.product.store, QStore.store).fetchJoin()
                                             .where(QProduct.product.productName.eq("상품1"))
                                             .fetch();

        for (Product product : products) {
            log.info("\n product name = {}, product price = {},  product quantity = {}, store name ={}",
                     product.getProductName(),
                     product.getPrice(),
                     product.getQuantity(),
                     product.getStore().getStoreName());
        }

    }

    @Test
    @DisplayName("세타 조인")
    /**
     * 연관관계 없는 필드로 조인
     */
    void querydslTesting8() {
        Store store1 = new Store("가게1");
        Store store2 = new Store("가게2");
        store1.changeProducts(Arrays.asList(new Product("상품1", 1000, 1000),
                                            new Product("상품2", 2000, 2000)));
        store2.changeProducts(Arrays.asList(new Product("상품1", 3000, 3000),
                                            new Product("상품2", 4000, 4000)));
        //초기화
        em.flush();
        em.clear();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Product> products = queryFactory.select(QProduct.product)
                                             .from(QProduct.product, QStore.store)
                                             .where(QProduct.product.productName.eq(QStore.store.storeName))
                                             .fetch();
        products.forEach(product -> log.info("\n products name = {}", product.getProductName()));

    }

    @Test
    @DisplayName("Ex) 상품과 가게를 조인하면서, 가게 이름이 ‘가게1’인 가게만 조인, 상품은 모두 조회")
    /**
     * Ex) 상품과 가게를 조인하면서, 가게 이름이 ‘가게1’인 가게만 조인, 상품은 모두 조회
     */
    void querydslTesting9() {
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
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> tuples = queryFactory.select(QProduct.product, QStore.store)
                                         .from(QProduct.product)
                                         .leftJoin(QProduct.product.store, QStore.store).on(QStore.store.storeName.eq("가게1"))
                                         .fetch();

        for (Tuple tuple : tuples) {
            log.info("\n tuple = {}", tuple.toString());
        }
    }

    @Test
    @DisplayName("Ex) 상품 이름과 가게 이름이 같은 대상 외부 조인")
    /**
     * Ex) 상품 이름과 가게 이름이 같은 대상 외부 조인
     */
    void querydslTesting10() {
        Store store1 = new Store("가게1");
        Store store2 = new Store("가게2");
        store1.changeProducts(Arrays.asList(new Product("가게1", 1000, 1000),
                                            new Product("상품2", 2000, 2000)));
        store2.changeProducts(Arrays.asList(new Product("상품1", 3000, 3000),
                                            new Product("가게2", 4000, 4000)));

        em.persist(store1);
        em.persist(store2);
        //초기화
        em.flush();
        em.clear();

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> tuples = queryFactory.select(QProduct.product, QStore.store)
                                         .from(QProduct.product)
                                         .leftJoin(QStore.store).on(QProduct.product.productName.eq(QStore.store.storeName))
                                         .fetch();

        for (Tuple tuple : tuples) {
            log.info("\n tuple = {}", tuple.toString());
        }
    }

    @Test
    @DisplayName("페치 조인")
    /**
     * Ex) 페치 조인
     */
    void querydslTesting11() {
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
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<Product> products = queryFactory.select(QProduct.product)
                                             .from(QProduct.product)
                                             .join(QProduct.product.store, QStore.store)
                                             .fetchJoin()
                                             .where(QProduct.product.productName.eq("상품1"))
                                             .fetch();

        for (Product product : products) {
            log.info("\n product name = {} , product price = {} , product quantity = {} , store Name = {}",
                     product.getProductName(),
                     product.getPrice(),
                     product.getQuantity(),
                     product.getStore().getStoreName());
        }

    }

    @Test
    @DisplayName("재고가 가장 많은 상품 조회")
    /**
     * Ex) 재고가 가장 많은 상품 조회
     */
    void querydslTesting12() {
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
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<Product> products = queryFactory.select(QProduct.product)
                                             .from(QProduct.product)
                                             .where(QProduct.product.quantity.eq(
                                                 JPAExpressions
                                                     .select(QProduct.product.quantity.max())
                                                     .from(QProduct.product)
                                             )).fetch();

        for (Product product : products) {
            log.info("product = {}", product);
        }
    }

    @Test
    @DisplayName(" 가격이 평균 이상인 상품 조회")
    /**
     * Ex) 가격이 평균 이상인 상품 조회
     * 이건 Ppt에 없는데 실습하면서 활용해서 이런것도 가능하다고 보여주자
     */
    void querydslTesting13() {
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
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<Product> products = queryFactory.select(QProduct.product)
                                             .from(QProduct.product)
                                             .where(QProduct.product.price.goe(
                                                 JPAExpressions
                                                     .select(QProduct.product.price.avg())
                                                     .from(QProduct.product)
                                             )).fetch();

        for (Product product : products) {
            log.info("product = {}", product);
        }
    }

    @Test
    @DisplayName(" 서브쿼리 여러건 처리 ")
    /**
     * Ex) 서브쿼리 여러건 처리
     * 이건 Ppt에 없는데 실습하면서 활용해서 이런것도 가능하다고 보여주자
     */
    void querydslTesting14() {
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
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<Product> products = queryFactory.select(QProduct.product)
                                             .from(QProduct.product)
                                             .where(QProduct.product.price.in(
                                                 JPAExpressions
                                                     .select(QProduct.product.price)
                                                     .from(QProduct.product)
                                                     .where(QProduct.product.price.gt(1000))
                                             )).fetch();

        for (Product product : products) {
            log.info("product = {}", product);
        }
    }

    @Test
    @DisplayName(" 셀렉트 절에 서브쿼리 ")
    /**
     * Ex) select 절에 subquery
     */
    void querydslTesting15() {
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
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<Tuple> tuples = queryFactory.select(QProduct.product.productName,
                                                 JPAExpressions.select(QProduct.product.price.avg()).from(QProduct.product))
                                         .from(QProduct.product)
                                         .fetch();

        for (Tuple tuple : tuples) {
            log.info("\n name = {} price = {}",
                     tuple.get(QProduct.product.productName),
                     tuple.get(JPAExpressions.select(QProduct.product.price.avg()).from(QProduct.product)));
        }

    }

    @Test
    @DisplayName(" case문 간단한 것  ")
    /**
     * Ex) case문 간단한 것
     */
    void querydslTesting16() {
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
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<String> prices = queryFactory.select(QProduct.product.price
                                                      .when(1000).then("저렴한 가격")
                                                      .when(2000).then("적당한 가격")
                                                      .when(3000).then("비싼 가격")
                                                      .otherwise("명품"))
                                          .from(QProduct.product)
                                          .fetch();

        log.info(" price List = {} ", prices);
    }

    @Test
    @DisplayName(" case문 복잡한 것  ")
    /**
     * Ex) case문 복잡한 것
     */
    void querydslTesting17() {
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

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<String> prices = queryFactory.select(new CaseBuilder()
                                                      .when(QProduct.product.price.between(1000, 1999)).then("저렴한 가격")
                                                      .when(QProduct.product.price.between(2000, 2999)).then("중간 가격")
                                                      .when(QProduct.product.price.between(3000, 3999)).then("비싼 가격")
                                                      .otherwise("명품"))
                                          .from(QProduct.product)
                                          .fetch();

        log.info(" price List = {} ", prices);
    }

    @Test
    @DisplayName(" case문 복잡한 것 2  ")
    /**
     * Ex) case문 복잡한 것 2
     *
     * 예를 들어서 다음과 같은 임의의 순서로 상품을 출력하고 싶다면?
     * 1. 2000 ~ 2999원이 아닌 상품을 가장 먼저 출력
     * 2. 0 ~ 1999원 상품 출력
     * 3. 나머지
     */
    void querydslTesting18() {
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

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        NumberExpression<Integer> rankPath = new CaseBuilder()
            .when(QProduct.product.price.between(2000, 2999)).then(1)
            .when(QProduct.product.price.between(0, 1999)).then(2)
            .otherwise(3);

        List<Tuple> result = queryFactory
            .select(QProduct.product.productName, QProduct.product.price, rankPath)
            .from(QProduct.product)
            .orderBy(rankPath.desc())
            .fetch();

        for (Tuple tuple : result) {
            log.info("\n name ={} price = {} rankPath = {}",
                     tuple.get(QProduct.product.productName),
                     tuple.get(QProduct.product.price),
                     tuple.get(rankPath));
        }
    }

    @Test
    @DisplayName(" querydsl 조회 세 가지 방법 ")
    /**
     *  querydsl 조회 세 가지 방법
     */
    void querydslTesting19() {
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

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<ProductDto> propertyFetch = queryFactory.select(Projections.bean(ProductDto.class,
                                                                              QProduct.product.productName,
                                                                              QProduct.product.price,
                                                                              QProduct.product.quantity))
                                                     .from(QProduct.product)
                                                     .fetch();

        List<ProductDto> fieldFetch = queryFactory
            .select(Projections.fields(ProductDto.class,
                                       QProduct.product.productName.as("name"),
                                       ExpressionUtils.as(
                                           JPAExpressions
                                               .select(QProduct.product.price.max())
                                               .from(QProduct.product), "price"),
                                       QProduct.product.quantity
                    )
            ).from(QProduct.product)
            .fetch();

        List<ProductDto> constructorFetch = queryFactory
            .select(Projections.constructor(ProductDto.class,
                                            QProduct.product.productName,
                                            QProduct.product.price,
                                            QProduct.product.quantity
                    )
            ).from(QProduct.product)
            .fetch();

        List<ProductDto> qConstructorFetch = queryFactory.select(
                                                             new QProductDto(QProduct.product.productName,
                                                                             QProduct.product.price,
                                                                             QProduct.product.price))
                                                         .from(QProduct.product)
                                                         .fetch();

    }

    @Test
    @DisplayName(" 동적 쿼리 - BooleanBuilder 사용 ")
    /**
     *  동적 쿼리 - BooleanBuilder 사용
     */
    void querydslTesting20() {
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

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        searchProduct1(null, 3000);

    }

    private List<Product> searchProduct1(String productName, Integer price) {
        BooleanBuilder builder = new BooleanBuilder();
        if (productName != null) {
            builder.and(QProduct.product.productName.eq(productName));
        }
        if (price != null) {
            builder.and(QProduct.product.price.eq(price));
        }
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return queryFactory
            .selectFrom(QProduct.product)
            .where(builder)
            .fetch();
    }

    private List<Product> searchProduct2(String productName, Integer price) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        return queryFactory
            .selectFrom(QProduct.product)
            .where(productNameEq(productName), priceEq(price))
            .fetch();
    }

    private BooleanExpression productNameEq(String productName) {
        return productName != null ? QProduct.product.productName.eq(productName) : null;
    }

    private BooleanExpression priceEq(Integer price) {
        return price != null ? QProduct.product.price.eq(price) : null;
    }

    @Test
    @DisplayName("  벌크 기존 숫자에1 더하기 ")
    /**
     *  벌크 기존 숫자에1 더하기
     */
    void querydslTesting21() {
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

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        // 수정 벌크 쿼리
        queryFactory
            .update(QProduct.product)
            .set(QProduct.product.price, QProduct.product.price.add(1))
            .execute();

        // 삭제 벌크 쿼리
        queryFactory
            .delete(QProduct.product)
            .where(QProduct.product.price.gt(3000))
            .execute();

    }

}
