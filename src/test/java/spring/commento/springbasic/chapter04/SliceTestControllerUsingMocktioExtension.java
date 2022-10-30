package spring.commento.springbasic.chapter04;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spring.commento.springbasic.chapter04.controller.ProductController;
import spring.commento.springbasic.chapter04.dto.ProductCreateDto;
import spring.commento.springbasic.chapter04.service.ProductService;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class SliceTestControllerUsingMocktioExtension {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                                 .build();
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("슬라이스 테스트 컨트롤러 Bddmockito")
    void sliceTest1() throws Exception {
        ProductCreateDto productCreateDto = ProductCreateDto.builder()
                                                            .name("상품1")
                                                            .price(1000)
                                                            .quantity(10000)
                                                            .build();

        String json = objectMapper.writeValueAsString(productCreateDto);

        BDDMockito.given(productService.createProduct(productCreateDto))
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
