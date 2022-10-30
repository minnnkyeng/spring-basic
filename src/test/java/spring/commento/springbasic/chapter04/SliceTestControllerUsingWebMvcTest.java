package spring.commento.springbasic.chapter04;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import spring.commento.springbasic.chapter04.controller.ProductController;
import spring.commento.springbasic.chapter04.dto.ProductCreateDto;
import spring.commento.springbasic.chapter04.service.ProductService;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
public class SliceTestControllerUsingWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("슬라이스 테스트 컨트롤러 BddMockito")
    void sliceTest1() throws Exception {
        ProductCreateDto productCreateDto = ProductCreateDto.builder()
                                                            .name("상품1")
                                                            .price(1000)
                                                            .quantity(10000)
                                                            .build();

        String json = objectMapper.writeValueAsString(productCreateDto);

        given(productService.createProduct(productCreateDto))
            .willReturn(1L);

        mockMvc.perform(post("/product")
                            .content(json)
                            .contentType(APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.body").value(1))
               .andDo(print());
    }

    @Test
    @DisplayName("슬라이스 테스트 컨트롤러 Mockito")
    void sliceTest2() throws Exception {
        ProductCreateDto productCreateDto = ProductCreateDto.builder()
                                                            .name("상품1")
                                                            .price(1000)
                                                            .quantity(10000)
                                                            .build();

        String json = objectMapper.writeValueAsString(productCreateDto);

        Mockito.doReturn(1L).when(productService).createProduct(productCreateDto);

        mockMvc.perform(post("/product")
                            .content(json)
                            .contentType(APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.body").value(1))
               .andDo(print());
    }
}
