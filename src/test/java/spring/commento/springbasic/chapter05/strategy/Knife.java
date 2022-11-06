package spring.commento.springbasic.chapter05.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Knife implements Weapon {
    @Override
    public void attack() {
        log.info("\n 슉 슉 ");
    }
}
