package spring.commento.springbasic.chapter02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.commento.springbasic.global.Member;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/chapter02/argument")
public class ArgumentController {

    @GetMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("member", Member.builder().userName("saechim")
                                             .age(28).pwd("1234").build());
        return "로그인 성공";
    }

    @GetMapping("/home")
    public String home(@SessionLogin Member member) {
        if (member == null) {
            return "로그인을 진행해주세요";
        }
        return "환영합니다 " + member.getUserName() + " 님";
    }
}
