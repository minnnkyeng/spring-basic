package spring.commento.springbasic.chapter02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@RestController
@Slf4j
@SessionAttributes("name")
@RequestMapping("/tmi")
public class TmiController {

    @GetMapping("/v0")
    public String tmiV0(HttpServletRequest request,
                      HttpServletResponse response,
                      HttpMethod httpMethod,
                      Locale locale,
                      @RequestHeader MultiValueMap<String, String>
                              headerMap,
                      @RequestHeader("host") String host,
                      @CookieValue(value = "tmiCookie", required = false) String cookie,
                      Model model){
        log.info("\n request = {} ",request);
        log.info("\n response = {}", response);
        log.info("\n httpMethod = {}",httpMethod);
        log.info("\n locale = {}", locale);
        log.info("\n headerMap = {}", headerMap);
        log.info("\n header name Host : {}" ,host);
        log.info("\n cookie ={}", cookie);
        log.info("\n session name = {}", request.getSession().getAttribute("name"));
        model.addAttribute("name","saechim");
        return "hello" + request.getSession().getAttribute("name");
    }

    // 이게 안좋은 버젼


    @GetMapping("/v1")
    public String tmiV1(HttpSession httpSession){

        Object name = httpSession.getAttribute("name");
        if(name == null)
            httpSession.setAttribute("name","saechim");

        return "name = "+name;
    }
}
