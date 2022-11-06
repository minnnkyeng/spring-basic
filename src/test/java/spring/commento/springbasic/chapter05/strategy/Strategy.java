package spring.commento.springbasic.chapter05.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Strategy {
    protected Weapon delegate;

    public void setDelegate(Weapon delegate) {
        log.info("\n 무기 착용 {}",delegate.getClass().getSimpleName());
        this.delegate = delegate;
    }

    abstract public void attack();
}
