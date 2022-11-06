package spring.commento.springbasic.chapter05.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {
    public RealSubject() {
        log.info("\n {}",this.getClass().getSimpleName()+" 객체 생성");
    }

    public String action1() {
        log.info("\n {}",this.getClass().getSimpleName()+" action1");
        return (this.getClass().getSimpleName() + ": action1");
    }

    public String action2() {
        log.info("\n {}",this.getClass().getSimpleName()+" action2");
        return (this.getClass().getSimpleName() + ": action2");
    }

    @Override
    public boolean isProxy() {
        return false;
    }
}
