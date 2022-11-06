package spring.commento.springbasic.chapter05.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BridgeMain {
    public static void main(String[] args) {
        testDevice(new TV());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        log.info("\n 베이직 리모트 테스트");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        basicRemote.volumeUp();
        device.printStatus();


        log.info("\n 어드밴스드 리모트 테스트");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        basicRemote.channelUp();
        device.printStatus();
    }
}