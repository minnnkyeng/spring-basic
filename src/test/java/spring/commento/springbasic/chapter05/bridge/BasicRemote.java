package spring.commento.springbasic.chapter05.bridge;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class BasicRemote implements Remote {
    protected Device device;
    @Override
    public void power() {
        log.info("\n BasicRemote power");
        if (device.isEnabled()) device.disable(); else device.enable();
    }
    @Override
    public void volumeDown() {
        log.info("\n BasicRemote volume down");
        device.setVolume(device.getVolume() - 10);
    }
    @Override
    public void volumeUp() {
        log.info("\n BasicRemote volume up");
        device.setVolume(device.getVolume() + 10);
    }
    @Override
    public void channelDown() {
        log.info("\n BasicRemote channel down");
        device.setChannel(device.getChannel() - 1);
    }
    @Override
    public void channelUp() {
        log.info("\n BasicRemote channel up");
        device.setChannel(device.getChannel() + 1);
    }
}