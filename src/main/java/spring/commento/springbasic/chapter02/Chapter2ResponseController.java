package spring.commento.springbasic.chapter02;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chapter02/response")
public class Chapter2ResponseController {

    @GetMapping("/v1")
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) //예시
    public String created(){
        return "created";
    }

    @GetMapping("/v2")
    public ResponseEntity<?> v2(){
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("company","samsung");
        headers.add("compnay","commento");
        headers.add("name","saechim");
        return new ResponseEntity<>("바디",headers,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/v3")
    public ResponseEntity<?> v3(){
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("company","sk");
        headers.add("compnay","commento");
        headers.add("name","saechim");
        return ResponseEntity.badRequest()
            .headers(new HttpHeaders(headers))
            .body("v3 바디");
    }
}
