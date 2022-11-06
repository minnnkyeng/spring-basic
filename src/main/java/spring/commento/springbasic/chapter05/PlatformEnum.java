package spring.commento.springbasic.chapter05;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum PlatformEnum {

    YOUTUBE("youtube"),
    GENIE("genie"),
    NOTHING("fail");

    private final String platformName;
    
    private static final Map<String, PlatformEnum> platFormMap =
        Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(PlatformEnum::getPlatformName, Function.identity())));

    public static PlatformEnum getPlatformByName(String platformName) {
        return platFormMap.getOrDefault(platformName, NOTHING);
    }
}
