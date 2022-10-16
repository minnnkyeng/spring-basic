package spring.commento.springbasic.chapter02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/chapter02/basic")
@Slf4j
public class Chapter2BasicController {

    @GetMapping("/v1")
    public String v1(HttpServletRequest request){
        return request.getParameter("name")+ " __ " + request.getParameter("message");
    }
    @GetMapping("/v2")
    public String v1(@RequestParam("name") String name , @RequestParam("message") String message){
        return name+ " __ "+ message;
    }

    @GetMapping("/v3")
    public String v3(@RequestParam Map<String, String> paramMap){
        return paramMap.get("name")+ " __ " + paramMap.get("message");
    }
    @GetMapping("/v4")
    public String v4(@RequestParam MultiValueMap<String, String> paramMap){
        paramMap.forEach((k,v )-> log.info("\n key {} value {}", k,v));
        return paramMap.get("name")+ " __ " + paramMap.get("message");
    }

    @GetMapping("/v5/{companyId}")
    public String v5(@PathVariable/*("companyId")*/ Long companyId){
        return companyMap.get(companyId).getName();
    }


    // controller -> service -> repository -> service -> controller
    @AllArgsConstructor
    @Getter
    static class Company{
        private String name; // 이름
        private String desc; // 설명
    }

    private Map<Long, Company> companyMap;

    @PostConstruct
    public void init(){
        companyMap = Map.of(1L, new Company("samsung","삼성"), 2L,new Company("commento","chapter2"));
    }
}
