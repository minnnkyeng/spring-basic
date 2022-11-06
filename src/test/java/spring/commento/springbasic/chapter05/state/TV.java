package spring.commento.springbasic.chapter05.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TV {
    private PowerState powerState;

    public TV() {
        log.info("\n {}",this.getClass().getSimpleName());
        this.powerState = new Off();
    }

    public void button() {
        powerState = powerState.button();
    }
}
