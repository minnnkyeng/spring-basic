package spring.commento.springbasic.chapter04.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.commento.springbasic.chapter04.domain.Product;
import spring.commento.springbasic.chapter04.dto.ProductCreateDto;
import spring.commento.springbasic.chapter04.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findProductById(Long id) {
        return productRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("없는 상품입니다"));
    }

    public Long createProduct(ProductCreateDto dto){
        return productRepository.save(ProductCreateDto.from(dto)).getId();
    }

}