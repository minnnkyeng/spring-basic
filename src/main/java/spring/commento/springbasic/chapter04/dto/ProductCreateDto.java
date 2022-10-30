package spring.commento.springbasic.chapter04.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.commento.springbasic.chapter04.domain.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductCreateDto {
    @NotEmpty
    private String name;
    @Min(1000)
    private int price;
    @Min(1)
    private int quantity;

    public static Product from(ProductCreateDto createDto){
        return new Product(createDto.getName(), createDto.getPrice(), createDto.getQuantity());
    }
}
