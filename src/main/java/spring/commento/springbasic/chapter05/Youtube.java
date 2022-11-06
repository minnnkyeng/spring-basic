package spring.commento.springbasic.chapter05;

import org.springframework.stereotype.Service;

@Service
public class Youtube implements Platform{
    @Override
    public String whatPlatform() {
        return "youtube music 입니다";
    }

    @Override
    public PlatformEnum getPlatformName() {
        return PlatformEnum.YOUTUBE;
    }
}
