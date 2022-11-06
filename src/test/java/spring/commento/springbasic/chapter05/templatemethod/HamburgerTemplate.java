package spring.commento.springbasic.chapter05.templatemethod;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class HamburgerTemplate {
    public final Hamburger make() {
        log.info("\n ==햄버거 만들기==");
        Hamburger hamburger = new Hamburger();
        String bread = bread();
        log.info("\n 1. 빵 올리기 :{}",bread);
        hamburger.setBread(bread);
        List<String> meatList = meatList();
        log.info("\n 2. 고가 올리기 :{}",meatList);
        hamburger.setMeat(meatList);
        String source = source();
        log.info("\n 3. 소스 올리기 :{}",source);
        hamburger.setSource(source);
        List<String> vegetableList = vegetableList();
        log.info("\n 4. 야채 올리기 :{}",vegetableList);
        hamburger.setVegetable(vegetableList);
        log.info("\n ===== 완성 =====");
        return hamburger;
    }

    protected abstract String bread();

    protected abstract List<String> meatList();

    protected abstract String source();

    abstract protected List<String> vegetableList();
}
