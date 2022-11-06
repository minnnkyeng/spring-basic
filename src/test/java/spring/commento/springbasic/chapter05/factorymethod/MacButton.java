package spring.commento.springbasic.chapter05.factorymethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MacButton implements Button {

    @Override
    public void render() {
        log.info("\n test button Mac");
        onClick();
    }

    @Override
    public void onClick() {
        log.info("\b Hello world Mac button");
    }
}
