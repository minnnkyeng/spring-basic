package spring.commento.springbasic.chapter05.bridge;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class Radio implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;
    @Override
    public boolean isEnabled() {
        return on;
    }
    @Override
    public void enable() {
        on = true;
    }
    @Override
    public void disable() {
        on = false;
    }
    @Override
    public int getVolume() {
        return volume;
    }
    @Override
    public void setVolume(int volume) {
        this.volume = volume > 100 ? 100 : Math.max(volume, 0);
    }
    @Override
    public int getChannel() {
        return channel;
    }
    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }
    @Override
    public void printStatus() {
        log.info("\n Radio Status {}",this);
    }
}