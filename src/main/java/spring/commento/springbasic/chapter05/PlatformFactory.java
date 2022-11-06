package spring.commento.springbasic.chapter05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class PlatformFactory {

    private Map<PlatformEnum, Platform> platformMap;

    @Autowired
    public PlatformFactory(Set<Platform> platformSet) {
        createPlatform(platformSet);
    }

    public Platform findPlatform(PlatformEnum platformEnum){
        return platformMap.get(platformEnum);
    }

    private void createPlatform(Set<Platform> platformSet) {
        platformMap = new HashMap<>();
        platformSet.forEach(m -> platformMap.put(m.getPlatformName(),m));
    }

}
