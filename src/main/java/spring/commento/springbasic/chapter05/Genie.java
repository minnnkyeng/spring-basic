package spring.commento.springbasic.chapter05;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Genie implements Platform{
    @Override
    public String whatPlatform() {
        return "지니 뮤직입니다";
    }

    @Override
    public PlatformEnum getPlatformName() {
        return PlatformEnum.GENIE;
    }
}
