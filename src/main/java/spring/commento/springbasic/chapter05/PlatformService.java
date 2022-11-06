package spring.commento.springbasic.chapter05;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlatformService {

    private final PlatformFactory platformFactory;

    public String platFormName(String platFormName){
        PlatformEnum platformByName = PlatformEnum.getPlatformByName(platFormName);
        Platform platform = Optional.ofNullable(platformFactory.findPlatform(platformByName))
                                    .orElseThrow(() -> new RuntimeException("없는 기능입니다"));
        return platform.whatPlatform();
    }
}
