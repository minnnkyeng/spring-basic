package spring.commento.springbasic.chapter04;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spring.commento.springbasic.chapter04.controller.ProductController;
import spring.commento.springbasic.chapter04.domain.Product;
import spring.commento.springbasic.chapter04.dto.ProductCreateDto;
import spring.commento.springbasic.chapter04.repository.ProductRepository;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@AutoConfigureMockMvc
@Slf4j
public class IntegrationControllerTest {

    @Autowired
    ProductController productController;

    //    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
//                                 .alwaysExpect(status().isOk())
                                 .build();

        productRepository.save(new Product("상품1", 1000, 10000));
    }

    @AfterEach
    void fin() {
        productRepository.deleteAll();
    }

    @Test
    @DisplayName("상품 통합 테스트")
    void integrationTest() throws Exception {

        ProductCreateDto productCreateDto = ProductCreateDto.builder()
                                                            .name("상품2")
                                                            .price(1000)
                                                            .quantity(10000)
                                                            .build();

        String json = objectMapper.writeValueAsString(productCreateDto);
        mockMvc.perform(post("/product")
                            .content(json)
                            .contentType(APPLICATION_JSON))
               .andExpect(status().isOk())
               .andDo(print());

        for (Product product : productRepository.findByProductName("상품2")) {
            log.info("\n name: {} , id :{} ,price : {} , quantity: {}",
                     product.getProductName(),
                     product.getId(),
                     product.getPrice(),
                     product.getQuantity());
        }

    }

    @Test
    @DisplayName("상품 통합 테스트 실패")
    void integrationTestFail() throws Exception {

        ProductCreateDto productCreateDto = ProductCreateDto.builder()
                                                            .name("상품1")
                                                            .price(0)
                                                            .quantity(0)
                                                            .build();

        String json = objectMapper.writeValueAsString(productCreateDto);

        mockMvc.perform(post("/product")
                            .content(json)
                            .contentType(APPLICATION_JSON))
               .andExpect(status().isBadRequest())
               .andDo(print());
    }

    @Test
    @DisplayName("조회하기")
    void integrationTest2() throws Exception {

        mockMvc.perform(get("/product/{productId}", 1)
                            .contentType(APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.body.id").value(1))
               .andExpect(jsonPath("$.body.productName").value("상품1"))
               .andExpect(jsonPath("$.body.quantity").value(10000))
               .andDo(print());
    }
}
