package spring.commento.springbasic.chapter05;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chapter05")
public class PlatformController {

    private final PlatformService platformService;

    @GetMapping("/{platformName}")
    public String getRuntimeStrategyPattern(@PathVariable String platformName){
        return platformService.platFormName(platformName);
    }
}
