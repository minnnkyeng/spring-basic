package spring.commento.springbasic.chapter05.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        log.info("\n Advanced Remote mute");
        device.setVolume(0);
    }
}

