package spring.commento.springbasic.chapter05.factorymethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WindowButton implements Button {

    @Override
    public void render() {
        log.info("\n test button Window");
        onClick();
    }

    @Override
    public void onClick() {
        log.info("\b Hello world Window button");
    }
}