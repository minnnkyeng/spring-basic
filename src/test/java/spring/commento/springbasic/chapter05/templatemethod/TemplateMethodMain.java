package spring.commento.springbasic.chapter05.templatemethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodMain {
    public static void main(String[] args) {
        HamburgerTemplate hamburgerTemplate1= new ChickenBurger();
        Hamburger hamburger1 = hamburgerTemplate1.make();

        log.info("\n hamburger1 \n {}",hamburger1);

        HamburgerTemplate hamburgerTemplate2 = new BulGogiBurger();
        Hamburger hamburger2 = hamburgerTemplate2.make();

        log.info("\n hamburger2 \n {}",hamburger2);


    }
}
