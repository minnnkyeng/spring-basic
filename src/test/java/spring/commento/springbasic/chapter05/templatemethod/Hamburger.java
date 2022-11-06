package spring.commento.springbasic.chapter05.templatemethod;

import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
public class Hamburger {
    private String bread;
    private List<String> meat;
    private String source;
    private List<String> vegetable;

}
