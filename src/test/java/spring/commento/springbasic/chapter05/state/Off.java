package spring.commento.springbasic.chapter05.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Off implements PowerState {
    @Override
    public PowerState button() {
        log.info("\n 전원 on");
        return new On();
    }
}
