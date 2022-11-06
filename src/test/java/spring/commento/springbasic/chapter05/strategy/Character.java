package spring.commento.springbasic.chapter05.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Character extends Strategy {
    @Override
    public void attack() {
        if (this.delegate == null)
            log.info("\n 펀치");
        else
            this.delegate.attack();
    }
}
