package spring.commento.springbasic.chapter04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.commento.springbasic.chapter04.domain.Product;
import spring.commento.springbasic.chapter04.repository.ProductRepository;
import spring.commento.springbasic.chapter04.service.ProductService;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    @DisplayName("productServiceTest")
    void serviceTest1_get() {

        Mockito.doReturn(Optional.of(new Product("테스트", 1000, 2000))).when(productRepository).findById(any());

        Product productById = productService.findProductById(2L);

        Assertions.assertThat(productById.getProductName()).isEqualTo("테스트");
    }

    @Test
    @DisplayName("productServiceTest")
    void serviceTest1_getThrow() {

        Mockito.doThrow(new RuntimeException("없는 상품")).when(productRepository).findById(any());

        Assertions.assertThatThrownBy(() -> productService.findProductById(2L)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("예외메세지 테스ㅡㅌ")
    void serviceTest1_getThrow2() {

        Mockito.doThrow(new RuntimeException("없는 상품")).when(productRepository).findById(any());

        Assertions.assertThatThrownBy(() -> productRepository.findById(100L)).hasMessage("없는 상품");

    }

    @Test
    @DisplayName("productServiceTest")
    void serviceTest1_Create() {

//        Mockito.doReturn(1L).when(productRepository).save(any());

        BDDMockito.given(productRepository.save(any())).willReturn(new Product("테스트가게1", 1000, 2000));

        Product test = productRepository.save(new Product("테스트 가게2", 2000, 3000));

        Assertions.assertThat(test.getProductName()).isEqualTo("테스트가게1");
    }

}
