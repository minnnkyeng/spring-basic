package spring.commento.springbasic.chapter01.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@Slf4j
public class LifeCycleConfig {

    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public LifeCycleExampleV2 lifeCycleExampleV2(){
        return new LifeCycleExampleV2();
    }

    @PostConstruct
    public void init(){
        log.info("\n postconstruct 호출");
    }

    @PreDestroy
    public void destory(){
        log.info("\n predestroy 호출");
   }

    @EventListener(ApplicationReadyEvent.class)
    public void eventListner(){
        log.info("\n event ");
   }
}

@Slf4j
class LifeCycleExampleV2{
    public void initMethod(){
        log.info("\n 초기화 표시 메서드");
    }

    public void destroyMethod(){
        log.info("\n 소멸전 표시 메서드");
    }
}
