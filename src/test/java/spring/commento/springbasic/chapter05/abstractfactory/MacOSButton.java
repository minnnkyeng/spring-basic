package spring.commento.springbasic.chapter05.abstractfactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MacOSButton implements Button {

    @Override
    public void paint() {
        log.info("\n macOsButton paint");
    }
}


