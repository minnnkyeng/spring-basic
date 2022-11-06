package spring.commento.springbasic.chapter05.templatemethod;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BulGogiBurger extends HamburgerTemplate {
    @Override
    protected String bread() {
        return "빵";
    }

    @Override
    protected List<String> meatList() {
        return Collections.singletonList("불고기");
    }

    @Override
    protected String source() {
        return "불고기맛 소스";
    }

    @Override
    protected List<String> vegetableList() {
        return Arrays.asList("양배추", "토마토");
    }
}
