package spring.commento.springbasic.chapter05.decorate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecorateMain {

    public static void main(String[] args) {
            IceCreamComponent iceCreamComponent1 = new Choco(new MintIceCreamConcreteComponent());

            log.info("\n iceCream1 {}", iceCreamComponent1.decorate());


        IceCreamComponent iceCreamComponent2 = new Choco(new Oreo(new MintIceCreamConcreteComponent()));
        log.info("\n iceCream2 {}",iceCreamComponent2.decorate());

    }
}
