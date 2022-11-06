package spring.commento.springbasic.chapter05;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum PlatformEnum {

    YOUTUBE("youtube"),
    GENIE("genie"),
    NOTHING("fail");

    private final String platformName;


    private static final Map<String, PlatformEnum> platFormMap = new HashMap<>();

    static {
        Arrays.stream(values()).forEachOrdered(platformEnum -> platFormMap.put(platformEnum.platformName,platformEnum));
    }

    public static PlatformEnum getPlatformByName(String platformName){
        return platFormMap.getOrDefault(platformName,NOTHING);
    }
}
