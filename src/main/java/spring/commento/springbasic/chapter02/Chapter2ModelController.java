package spring.commento.springbasic.chapter02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/chapter02/model")
@Slf4j
public class Chapter2ModelController {

    // http://localhost:8080/chapter02/model/v1?foodName=banana&price=2000
    @GetMapping("/v1")
    public String v1(@ModelAttribute Fruit fruit){
        log.info("\n fruit = {}" , fruit);
        return fruit.getFoodName();
    }

    @GetMapping("/v2")
    public String v2(Fruit fruit){
        log.info("\n fruit = {}" , fruit);
        return fruit.getFoodName();
    }

    @PostMapping("/v3")
    public String v3(@RequestBody @Valid Fruit fruit){
        return "fruitName = " + fruit.getFoodName() + "fruit price = " + fruit.getPrice();
    }


    @AllArgsConstructor
    @Getter
    @ToString
    static class Fruit{
        // null X  "" X   "     " X
        @NotEmpty(message = "빈 문자열을 넣지 말아주세요")
        private final String foodName;

        @Min(value = 100)
        private final int price;
    }
}
