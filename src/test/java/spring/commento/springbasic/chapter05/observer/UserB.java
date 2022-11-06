package spring.commento.springbasic.chapter05.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserB extends Observer {
    public UserB(String name) {
        this.setName(name);
    }

    @Override
    public void update() {
        log.info("\n {} 을 갱신합니다",this.getName());
    }
}
